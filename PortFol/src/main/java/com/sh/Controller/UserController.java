package com.sh.Controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.sh.Dto.Address;
import com.sh.Dto.Cart;
import com.sh.Dto.OrderInfo;
import com.sh.Dto.Product;
import com.sh.Dto.ReplyDto;
import com.sh.Dto.UserDto;
import com.sh.Dto.UserRequest;
import com.sh.Enum.DeliverySituation;
import com.sh.Enum.PermissionToComment;
import com.sh.Service.AddressService;
import com.sh.Service.AdminService;
import com.sh.Service.OrderService;
import com.sh.Service.ReplyService;
import com.sh.Service.UserService;
import com.sh.Service.UserSha256;


@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	private UserService userService;
	@Inject 
	private AdminService adminService;
	@Inject 
	private ReplyService replyService;
	@Inject 
	private OrderService orderService;
	@Inject 
	private AddressService addressService;
	@Inject
	private KakaoController kakaoController;
	@Inject
	private NaverLoginBO naverLoginBO;
	private String apiResult;
	
	@Autowired
	public void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}
	
	
	@GetMapping("/signup")
	public void getSignUp() {
		logger.info("Get SignUp ");
		System.out.println("Get SignUp");
	}
	
	@PostMapping("/signup")
	public String postSignUp(UserDto dto) throws Exception{
		logger.info("Post SignUp");
		
		int result  = userService.idValidation(dto);
				
		try {
			if(result == 1) {
				return "${pageContext.request.contextPath}/register";
			}else if(result == 0) {
				String encryPassword = UserSha256.encrypt(dto.getUserPass());
				dto.setUserPass(encryPassword);

				userService.register(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return"redirect:/signin";
	}
	
	@GetMapping("/signin")
	public void getSignup(Model model , HttpSession session)throws Exception{
		logger.info("Get Signin");
		System.out.println("Get Signin");
		
		 String kakaoUrl = KakaoController.getAuthorizationUrl(session);
		 String naverUrl = naverLoginBO.getAuthorizationUrl(session);
	      // ?????????
	      System.out.println("?????????:" + kakaoUrl);
	      System.out.println("?????????:" + naverUrl);
	      
	      model.addAttribute("kakao_url", kakaoUrl);	
	      model.addAttribute("naver_url", naverUrl);	
		}	
	

   @RequestMapping(value = "/kakao/callback", produces = "application/json", method = { RequestMethod.GET,RequestMethod.POST })
   public String kakaoLogin(@RequestParam("code") String code, HttpServletRequest request,
		   			HttpServletResponse response, HttpSession session, Model model , UserDto dto) throws Exception {
	   System.out.println("Code : " + code);
	   // ???????????? node??? ?????????
      JsonNode node = KakaoController.getAccessToken(code);
      System.out.println("???????????? ????????? ?????? : "+node.toString());
      // accessToken??? ???????????? ???????????? ?????? ????????? ????????????
      JsonNode accessToken = node.get("access_token");
      System.out.println("???????????? ???????????? ?????? ????????? ???????????? accessToken : " + accessToken);
      // ???????????? ??????
      JsonNode userInfo = KakaoController.getKakaoUserInfo(accessToken);
      String kemail = null;
      String kname = null;
      String kgender = null;
      String kbirthday = null;
      String kage = null;
      String kimage = null;
      // ???????????? ??????????????? ???????????? Get properties
      JsonNode properties = userInfo.path("properties");
      JsonNode kakao_account = userInfo.path("kakao_account");
      kemail = kakao_account.path("email").asText();
      kname = properties.path("nickname").asText();
      kimage = properties.path("profile_image").asText();
      kgender = kakao_account.path("gender").asText();
      kbirthday = kakao_account.path("birthday").asText();
      kage = kakao_account.path("age_range").asText();
      session.setAttribute("kemail", kemail);            //session?????? ???????????? redirect??? ??????
      session.setAttribute("kname", kname); // ?????? ??????      //redirect ????????? ????????? ??? ???????????? ??? ??????
      session.setAttribute("kimage", kimage);
      session.setAttribute("kgender", kgender);
      session.setAttribute("kbirthday", kbirthday);
      session.setAttribute("kage", kage);

      dto.setUserId(kemail+"_K");
      dto.setUserName(kname);
      dto.setPlatform("K");
      if(idValidation(dto) == 0) {	// ???????????? DB??? ?????? ???
      userService.register(dto);
      		return "redirect:/main?n="+kemail;
      }else {						// ???????????? DB??? ?????? ???
          return "redirect:/main?n="+kemail;
      }
   }		

   //????????? ????????? ????????? callback?????? ?????????
   @RequestMapping(value = "/naver/callback", method = { RequestMethod.GET, RequestMethod.POST })
   public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session , UserDto dto)
           throws Exception {
       System.out.println("Naver callback");
       OAuth2AccessToken oauthToken;
       oauthToken = naverLoginBO.getAccessToken(session, code, state);
       // 1. ????????? ????????? ????????? ????????????.
       apiResult = naverLoginBO.getUserProfile(oauthToken); // String????????? json?????????

       // 2. String????????? apiResult??? json????????? ??????
       JSONParser parser = new JSONParser();
       Object obj;
       try {
          obj = parser.parse(apiResult);
          JSONObject jsonObj = (JSONObject) obj;
          System.out.println(jsonObj.toString());
          // 3. ????????? ??????
          // Top?????? ?????? _response ??????
          JSONObject response_obj = (JSONObject) jsonObj.get("response");
          // response??? nickname??? ??????
          String name = (String) response_obj.get("name");
          String email = (String)response_obj.get("email");
          String phone = (String)response_obj.get("mobile");

          dto.setUserId(email+"_N");
          dto.setUserName(name);
          dto.setUserPhone(phone);
          dto.setPlatform("N");
          int result = userService.idValidation(dto);
	      if(result == 1) { // ????????? ??????
	          // ?????? o
	    	  System.out.println("?????????(?????? x )");	    	 
	    	  return "redirect:/main?n="+email;	
	      } else if(result == 0){
	          // ?????? x 
	          userService.register(dto);
	    	  return "redirect:/main?n="+email;	
          }
       } catch (org.json.simple.parser.ParseException e) {
          e.printStackTrace();
       }
       model.addAttribute("result", apiResult);
       return "";
    }
   
	@PostMapping("/signin")
	public String postSignin(UserDto dto , HttpServletRequest req , 
							RedirectAttributes rttr , Model model)throws Exception {
		logger.info("Post Signin");
		
		String test = dto.getUserId();		
		model.addAttribute("user" , userService.myInfo(dto));
		HttpSession session = req.getSession();
		
		String encryPassword = UserSha256.encrypt(dto.getUserPass());
		dto.setUserPass(encryPassword);
		UserDto login = userService.signin(dto);
		if(login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg" , false);
			return "signin";
		}else {			
			session.setAttribute("member", login);
			if(login.getVerify() == 9) {
				return"redirect:/admin/index";
			}else {
				return"redirect:/main?n="+test;
			}
		}
	}
	
	
	@GetMapping("/signout")
	public String signout(HttpSession session ,HttpServletRequest req  )throws Exception {
		logger.info("SignOut");

		userService.signout(session);
		System.out.println("SignOut");

		return"redirect:/main";
	}

	@GetMapping("/userDelete")
	public void GetUserDelete(@RequestParam(value="n" , required=false) String string) throws Exception{
		logger.info("Get userDelete");
		System.out.println("Get UserDelete");
		
		System.out.println("string : " + string);
	}
	@PostMapping("/userDelete")
	public String PostUserDelete(@RequestParam(value="n" , required=false) String string ,
								UserDto dto , HttpSession session , RedirectAttributes rttr
								, String deletePass ,Model model) throws Exception{
		logger.info("Post userDelete");
		System.out.println("Post UserDelete");
		// ?????? ??? ?????? ???
		
		//????????? ????????????
		String encryPassword2 = UserSha256.encrypt(deletePass);
		System.out.println("????????? Password ????????? : "+ encryPassword2);
		dto.setUserId(string);
		// DB??? ?????? ???????????? ??? ??? ???????????? ???????????? ?????????
		System.out.println("DB?????? ????????? ???????????? : " + userService.myInfo(dto).getUserPass());
		
		
		if(encryPassword2.equals(userService.myInfo(dto).getUserPass())) {	// ==(?????? ?????????) ???  equals ??? ??????
			// ???????????? ??? ??????????????? ?????? ???
			System.out.println("?????? ??????");
			dto.setUserId(string);
			dto.setUserPass(encryPassword2);
			userService.userDelete(dto);
			session.invalidate();
			return "main";
		}else {
			// ???????????? ??? ??????????????? ?????? ?????? ???
			System.out.println("pass ?????????");
			return "redirect:/userDelete?n="+string;
		}
		
	}


	@ResponseBody
	@PostMapping("passValidation")
	public int passValidation(UserDto dto) throws Exception{
		System.out.println("Post passValidation");

		int result = userService.passValidation(dto);
		System.out.println("result : " + result);
		return result;
	}
	

	@ResponseBody
	@PostMapping("idValidation")
	public int idValidation(UserDto dto) throws Exception{
		System.out.println("Post IdValidation");

		int result = userService.idValidation(dto);
		return result;
	}
	
	@GetMapping("/main")
	public void getMainPage(@RequestParam(value="n" , required=false) String string ,Model model  
							, UserDto dto , HttpServletRequest req) throws Exception {
		logger.info("Main Page");
		System.out.println("MainPage");

		HttpSession session = req.getSession();
		model.addAttribute("member2" , session.getAttribute("member"));

		model.addAttribute("prolist", adminService.proList());
  		dto.setUserId(string);
		model.addAttribute("user" , userService.myInfo(dto));
		
	}
	
	@GetMapping("/proInfo")
	public void getProInfo(	@RequestParam(value = "n" , required = false) String string ,
							@RequestParam(value = "bno", required = false) int bno ,
							@RequestParam(value = "orderId", required = false) String orderId 
							,Model model , Product pro , UserDto dto , OrderInfo orderInfo
							, PermissionToComment ptc , HttpServletRequest req ) throws Exception {
		logger.info("Get ProInfo");
		HttpSession session = req.getSession();
		model.addAttribute("member2" , session.getAttribute("member"));

		
		pro.setBno(bno);
		dto.setUserId(string);
		System.out.println("bno : " + pro.getBno());
		model.addAttribute("pro", adminService.proView(pro.getBno())); 

		List<ReplyDto> replyList = replyService.readReply(pro.getBno());
		model.addAttribute("user", userService.myInfo(dto));		
		model.addAttribute("replyList", replyList);
		orderInfo.setUserId(string);
		orderInfo.setOrderId(orderId);
		
		if(orderId != null) {
			if(userService.myOrdered(orderInfo).getReplyEnum() == ptc.ON) {
				model.addAttribute("reply" , userService.myOrdered(orderInfo).getReplyEnum());			
			}else {
				model.addAttribute("reply" , null);
			}
		}
		
	}
	
	@GetMapping("/replyWrite")	//proInfo ?????? ???????????? reply_insert ??? ?????? proInfo??? ????????? ??? ????????? value ??? ??????
								// ${user.userName} ?????? ${member.userName} ??? ????????? ?????? 
								// ${user.userName} ??? ??? 1??????????????? ?????? ????????? ??????????
	
	public String replyWrite(@RequestParam("n") String string,
							 @RequestParam("bno") int bno 
							 ,ReplyDto replydto , RedirectAttributes rttr , Product pro , Model model
							 , UserDto dto) throws Exception {
		logger.info("Get ReplyWrite");
		System.out.println("Get ReplyWrite");
		
		System.out.println("bno : " + bno);
		System.out.println("string : " + string);

		
		replydto.setBno(bno);
		replyService.writeReply(replydto);

		dto.setUserId(string);
		System.out.println("dto.toString : "+dto.toString());

		model.addAttribute("user", userService.myInfo(dto));

		
		String test = "redirect:/proInfo?n="+string +"&bno="+bno;
	
		return test;
	}

	@GetMapping("/myInfo")
	public void getMyInfo(@RequestParam(value="n" , required=false) String string, Model model , UserDto dto, HttpServletRequest req) throws Exception {
		logger.info("My Info");
		dto.setUserId(string);
		model.addAttribute("user", userService.myInfo(dto));

		HttpSession session = req.getSession();
		model.addAttribute("member2" , session.getAttribute("member"));

	}

	
	@GetMapping("/userUpdate")
	public void GetUserUpdate(@RequestParam(value = "n" )String string , UserDto dto,
								Model model , HttpServletRequest req) throws Exception {
		logger.info("Get userUpdate");
  		System.out.println("Get UserUpdate");
		dto.setUserId(string);  		
		model.addAttribute("info" , userService.myInfo(dto));

		HttpSession session = req.getSession();
		model.addAttribute("member2" , session.getAttribute("member"));
  		

	}
	
	@PostMapping("/userUpdate")
	public String PostUserUpdate(UserDto dto , HttpSession session 
					,String infoUserId , String infoUserName,String infoUserPhone,String infoUserAddress) throws Exception{
		logger.info("Post userUpdate");
		System.out.println("Post UserUpdate");
		userService.userUpdate(dto);
		session.invalidate();

		return "redirect:/myInfo"; // +string
	}

	@GetMapping("/orderPage")
	public void getOrderPage(@RequestParam("n") String string 
							,@RequestParam("bno") int bno
							,OrderInfo orderInfo , Model model , UserDto dto ,Product pro ,HttpServletRequest req) throws Exception {
		logger.info("Get OrderPage");

		HttpSession session = req.getSession();
		model.addAttribute("member2" , session.getAttribute("member"));

		dto.setUserId(string);
		model.addAttribute("member" , userService.myInfo(dto));

		
		// ???????????? ??? ???????????? ????????????
		model.addAttribute("pro" , adminService.proView(bno));

	}

	@PostMapping("orderPage")
	public String postOrderPage(@RequestParam("n") String string 
								,@RequestParam("bno") int bno
								,OrderInfo orderInfo , Model model , UserDto dto , Address address
								, BindingResult bindingResult , Product pro
								,DeliverySituation userEnum , PermissionToComment ptc ) throws Exception {
		logger.info("POST OrderPage");
		System.out.println("POST OrderPage");	
		//
		//
		dto.setUserId(string);
		orderInfo.setUserId(userService.myInfo(dto).getUserId());
		orderInfo.setProCode(adminService.proView(bno).getProCode());
		orderInfo.setAddress(userService.myInfo(dto).getAddress());
		orderInfo.setOrderPrice(adminService.proView(bno).getProPrice());
		orderInfo.setDeliveryInfo(userEnum.Ready);
		orderInfo.setProPrice(orderInfo.getOrderStock() * orderInfo.getOrderPrice());
		orderInfo.setOrderProName(adminService.proView(bno).getProName());
		orderInfo.setReplyEnum(ptc.ON);
		
		
		
		userService.PtcUpdate(orderInfo);
		orderService.order(orderInfo);
		
		// ?????? ??? ?????? ????????????

		//address ?????? ??????
		address.setUserId(userService.myInfo(dto).getUserId());
		orderInfo.setDeliveryInfo(userEnum.Ready);
		System.out.println("userVerify : " + userService.myInfo(dto).getVerify());
		System.out.println("enum class test : " + orderInfo.getDeliveryInfo());

		
		
		
		addressService.insertAddress(address);
		//
		// ?????? ?????? On


		// ?????? ?????? minus
		System.out.println("proCode : " + orderInfo.getProCode());
		System.out.println("proStock : " + orderInfo.getOrderStock());
		adminService.minusProStock(orderInfo);
		return "redirect:/main?n="+string;
	}

//	@GetMapping("/?????? ?????? ?????????")
//	public void ????????????_?????????(Order order) throws Exception {
//		}
//	}



	@GetMapping("/deliveryInfo")
	public void getDeliveryInfo(@RequestParam(value="n" , required=false) String string
								,OrderInfo orderInfo , UserDto dto , Model model ,HttpServletRequest req) throws Exception {
		logger.info("Get DeliveryInfo");

		HttpSession session = req.getSession();
		model.addAttribute("member2" , session.getAttribute("member"));
		// ??????????????? ????????? ????????? ??????????????? ?????? ?????? 
		dto.setUserId(string);
		
		System.out.println("userId : "+ dto.getUserId());
		orderInfo.setUserId(string);
		
		model.addAttribute("user",userService.myInfo(dto));
		model.addAttribute("orderList",userService.orderList(dto.getUserId()));
		
		
	}
	
	
		
	@GetMapping("refund")
	public void getRefund(@RequestParam(value = "userId" , required = false) String userId
						 ,@RequestParam(value = "orderId" , required = false) String orderId
						 ,@RequestParam(value = "proCode" , required = false) String proCode
						 , UserDto dto , Model model , OrderInfo orderInfo)throws Exception {
		logger.info("Get Refund Page");
		System.out.println("Get Refund Page");

		System.out.println("????????? ?????? ????????? : " + orderId );
		System.out.println("????????? ????????? : " + userId);
		System.out.println("????????? proCode : " + proCode);
		dto.setUserId(userId);

		orderInfo.setUserId(userId);
		orderInfo.setOrderId(orderId);
		
		model.addAttribute("ordered" , userService.myOrdered(orderInfo));
		System.out.println("Check Refund orderProName : "+userService.myOrdered(orderInfo).getOrderProName());
		System.out.println("Check Refund orderPrice : "+userService.myOrdered(orderInfo).getOrderPrice());
		System.out.println("Check Refund orderStock : "+userService.myOrdered(orderInfo).getOrderStock());
	}
	
	@PostMapping("refund")
	public String postRefund(@RequestParam(value = "userId" , required = false)String userId
							,@RequestParam(value = "orderId" , required = false)String orderId
							 ,@RequestParam(value = "proCode" , required = false) String proCode
							 ,@RequestParam(value = "Rs_Refund_text" , required = false) String Rs_Refund_text
							 ,String Rs_Refund_option  
							 ,UserDto dto , OrderInfo orderInfo , HttpServletRequest req
							, DeliverySituation ds , PermissionToComment ptc , UserRequest userReq) throws Exception {
		logger.info("Post Refund");
		System.out.println("Post Refund");
		System.out.println("userId : " + userId); // -> ????????????
		System.out.println("orderId : " + orderId);
		System.out.println("proCode   : " + proCode);
		System.out.println("option : " + req.getParameter("Rs_Refund_option"));
		System.out.println("text : " + Rs_Refund_text);
		// ?????? ?????? ??????
		
		userReq.setChoose("Refund");
		userReq.setUserId(userId);
		userReq.setOrderId(orderId);
		userReq.setProCode(proCode);
		userReq.setRs_Refund_option(req.getParameter("Rs_Refund_option"));
		userReq.setRs_Refund_text(Rs_Refund_text);
		adminService.reqRefund_Cancel(userReq);
		
		// user -> deliveryInfo -> ??????  ?????? = stop_for_refund ??????
		orderInfo.setUserId(userId);
		orderInfo.setOrderId(orderId);
		orderInfo.setDeliveryInfo(ds.Stop_for_refund);
		orderInfo.setOrderStock(userService.myOrdered(orderInfo).getOrderStock());
		userService.DsUpdate(orderInfo);
		System.out.println("proCode : " + orderInfo.getProCode());
		System.out.println("proStock : " + orderInfo.getOrderStock());
		adminService.plusProStock(orderInfo);

		orderInfo.setReplyEnum(ptc.OFF);
		userService.PtcUpdate(orderInfo);
		return "redirect:/main?n="+userId;
	}
	
	
	@GetMapping("/cancel")
	public String cancel(@RequestParam(value = "n" , required = false)String userId
					    ,@RequestParam(value = "bno" , required = false)String orderId
					    ,@RequestParam(value = "proCode" , required = false) String proCode
					    ,UserDto dto , OrderInfo orderInfo 
					    ,DeliverySituation ds , PermissionToComment ptc ) throws Exception {
		logger.info("Get cancel");
		System.out.println("Get cancel");
		
			
		orderInfo.setUserId(userId);
		orderInfo.setOrderId(orderId);
		orderInfo.setDeliveryInfo(ds.Stop_for_delivery_Cancel);
		orderInfo.setOrderStock(userService.myOrdered(orderInfo).getOrderStock());
		orderInfo.setReplyEnum(ptc.OFF);

		System.out.println("proCode : " + proCode);
		System.out.println("orderStock : " + orderInfo.getOrderStock());

		adminService.plusProStock(orderInfo);
		userService.DsUpdate(orderInfo);
		userService.PtcUpdate(orderInfo);

		return "redirect:/main?n="+userId;
	}
	
	@GetMapping("/goCart")
	public String goCart(@RequestParam(value = "n" , required = false) String string
						,@RequestParam(value = "bno" , required = false) int bno
						, Cart cart) throws Exception {
		logger.info("get goCart");
		System.out.println("get goCart");
		System.out.println("bno : " + bno);
		System.out.println("string : " + string);
		System.out.println("price : " + adminService.proView(bno).getProPrice());
		System.out.println("proCode : " + adminService.proView(bno).getProCode());
		System.out.println("proName : " + adminService.proView(bno).getProName());
		System.out.println("???????????????????????????????????????????????????????????????????????????????????????");
		cart.setUserId(string);
		cart.setProPrice(adminService.proView(bno).getProPrice());
		cart.setProCode(adminService.proView(bno).getProCode());
		cart.setOrderName(adminService.proView(bno).getProName());

		System.out.println("cart userId : " + cart.getUserId());
		System.out.println("cart proPrice : " + cart.getProPrice());
		System.out.println("cart proCode : " + cart.getProCode());
		System.out.println("cart orderName : " + cart.getOrderName());
		
		
		userService.goCart(cart);
		String url = "redirect:/proInfo?n="+string+"&bno="+bno;
		System.out.println("url : " + url);
		return url;
	}
	
	@GetMapping("/cart")
	public void cart() throws Exception {
		logger.info("get cart");
		System.out.println("get cart");

	}
	
}
