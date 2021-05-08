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
		System.out.println("Post SignUp");
		
		int result  = userService.idValidation(dto);
				
		try {
			if(result == 1) {
				return "${pageContext.request.contextPath}/register";
			}else if(result == 0) {
				System.out.println("id : " + dto.getUserId());
				System.out.println("name : " + dto.getUserName());
				System.out.println("phone : " + dto.getUserPhone());
				System.out.println("address : " + dto.getAddress());
				System.out.println("joinDate : " + dto.getUserJoinDate());
				System.out.println("verify    : " + dto.getVerify());
				System.out.println("암호화 전 비밀번호 : " + dto.getUserPass());
				String encryPassword = UserSha256.encrypt(dto.getUserPass());
				dto.setUserPass(encryPassword);
				System.out.println("암호화 후 비밀번호 : " + dto.getUserPass());
				
				userService.register(dto);
			}
		}catch (Exception e) {

		}
		
		return"redirect:/signin";
	}
	
	@GetMapping("/signin")
	public void getSignup(Model model , HttpSession session)throws Exception{
		logger.info("Get Signin");
		System.out.println("Get Signin");
		
		 String kakaoUrl = KakaoController.getAuthorizationUrl(session);
		 String naverUrl = naverLoginBO.getAuthorizationUrl(session);
	      // 카카오
	      System.out.println("카카오:" + kakaoUrl);
	      System.out.println("네이버:" + naverUrl);
	      
	      model.addAttribute("kakao_url", kakaoUrl);	
	      model.addAttribute("naver_url", naverUrl);	
		}	
	

   @RequestMapping(value = "/kakao/callback", produces = "application/json", method = { RequestMethod.GET,RequestMethod.POST })
   public String kakaoLogin(@RequestParam("code") String code, HttpServletRequest request,
		   			HttpServletResponse response, HttpSession session, Model model , UserDto dto) throws Exception {
	   System.out.println("Code : " + code);
	   // 결과값을 node에 담아줌
      JsonNode node = KakaoController.getAccessToken(code);
      System.out.println("결과값을 노드에 담음 : "+node.toString());
      // accessToken에 사용자의 로그인한 모든 정보가 들어있음
      JsonNode accessToken = node.get("access_token");
      System.out.println("사용자의 로그인한 모든 정보가 들어있는 accessToken : " + accessToken);
      // 사용자의 정보
      JsonNode userInfo = KakaoController.getKakaoUserInfo(accessToken);
      String kemail = null;
      String kname = null;
      String kgender = null;
      String kbirthday = null;
      String kage = null;
      String kimage = null;
      // 유저정보 카카오에서 가져오기 Get properties
      JsonNode properties = userInfo.path("properties");
      JsonNode kakao_account = userInfo.path("kakao_account");
      kemail = kakao_account.path("email").asText();
      kname = properties.path("nickname").asText();
      kimage = properties.path("profile_image").asText();
      kgender = kakao_account.path("gender").asText();
      kbirthday = kakao_account.path("birthday").asText();
      kage = kakao_account.path("age_range").asText();
      session.setAttribute("kemail", kemail);            //session으로 담아줘야 redirect가 가능
      session.setAttribute("kname", kname); // 세션 생성      //redirect 해줘야 로그인 후 그래프가 잘 나옴
      session.setAttribute("kimage", kimage);
      session.setAttribute("kgender", kgender);
      session.setAttribute("kbirthday", kbirthday);
      session.setAttribute("kage", kage);

      dto.setUserId(kemail+"_K");
      dto.setUserName(kname);
      dto.setPlatform("K");
      if(idValidation(dto) == 0) {	// 아이디가 DB에 없을 때
      userService.register(dto);
      		return "redirect:/main?n="+kemail;
      }else {						// 아이디가 DB에 있을 때
          return "redirect:/main?n="+kemail;
      }
   }		

   //네이버 로그인 성공시 callback호출 메소드
   @RequestMapping(value = "/naver/callback", method = { RequestMethod.GET, RequestMethod.POST })
   public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session , UserDto dto)
           throws Exception {
       System.out.println("Naver callback");
       OAuth2AccessToken oauthToken;
       oauthToken = naverLoginBO.getAccessToken(session, code, state);
       // 1. 로그인 사용자 정보를 읽어온다.
       apiResult = naverLoginBO.getUserProfile(oauthToken); // String형식의 json데이터

       // 2. String형식인 apiResult를 json형태로 바꿈
       JSONParser parser = new JSONParser();
       Object obj;
       try {
          obj = parser.parse(apiResult);
          JSONObject jsonObj = (JSONObject) obj;
          System.out.println(jsonObj.toString());
          // 3. 데이터 파싱
          // Top레벨 단계 _response 파싱
          JSONObject response_obj = (JSONObject) jsonObj.get("response");
          // response의 nickname값 파싱
          String name = (String) response_obj.get("name");
          String email = (String)response_obj.get("email");
          String phone = (String)response_obj.get("mobile");

          dto.setUserId(email+"_N");
          dto.setUserName(name);
          dto.setUserPhone(phone);
          dto.setPlatform("N");
          int result = userService.idValidation(dto);
	      if(result == 1) { // 아이디 체크
	          // 중복 o
	    	  System.out.println("로그인(가입 x )");	    	 
	    	  return "redirect:/main?n="+email;	
	      } else if(result == 0){
	          // 중복 x 
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
		System.out.println("Post Signin");
		
		String test = dto.getUserId();		
		model.addAttribute("user" , userService.myInfo(dto));
		HttpSession session = req.getSession();
		
		
		String encryPassword = UserSha256.encrypt(dto.getUserPass());
		dto.setUserPass(encryPassword);
		System.out.println(dto.getUserPass());

		UserDto login = userService.signin(dto);
		if(login != null) {
			session.setAttribute("member", login);

			System.out.println();
			return"redirect:/nav?n="+test;
		}else {
			session.setAttribute("member", null);
			rttr.addAttribute("msg" , false);
			System.out.println("Login false");
			return "signin";
		}
	}
	
	
	@GetMapping("/signout")
	public String signout(HttpSession session)throws Exception {
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
		// 내가 짠 코드 ↓
		
		//넘어온 패스워드
		String encryPassword2 = UserSha256.encrypt(deletePass);
		System.out.println("입력된 Password 암호화 : "+ encryPassword2);
		dto.setUserId(string);
		// DB에 있는 회원가입 할 때 암호화된 패스워드 가져옴
		System.out.println("DB에서 가져온 비밀번호 : " + userService.myInfo(dto).getUserPass());
		
		
		if(encryPassword2.equals(userService.myInfo(dto).getUserPass())) {	// ==(연산 비교자) 와  equals 의 차이
			// 암호화된 두 비밀번호가 같을 때
			System.out.println("탈퇴 성공");
			dto.setUserId(string);
			dto.setUserPass(encryPassword2);
			userService.userDelete(dto);
			session.invalidate();
			return "main";
		}else {
			// 암호화된 두 비밀번호가 같지 않을 때
			System.out.println("pass 불일치");
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
	public void getMainPage(@RequestParam(value="n" , required=false) String string ,Model model , HttpServletRequest req , UserDto dto) throws Exception {
		logger.info("Main Page");
		System.out.println("MainPage");
		model.addAttribute("prolist", adminService.proList());
		dto.setUserId(string);
		model.addAttribute("user" , userService.myInfo(dto));
		//내가 짠 코드
		
		// 여기까지
		
	}
	
	@GetMapping("/proInfo")
	public void getProInfo(	@RequestParam(value = "n" , required = false) String string ,
							@RequestParam(value = "bno", required = false) int bno ,
							@RequestParam(value = "orderId", required = false) String orderId 
							,Model model , Product pro , UserDto dto , OrderInfo orderInfo
							, PermissionToComment ptc) throws Exception {
		logger.info("Get ProInfo");
		System.out.println("Get ProInfo");
		
		System.out.println("String : " + string);

		System.out.println("orderId : " + orderId);
		
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
				System.out.println("replyEnum : " + userService.myOrdered(orderInfo).getReplyEnum());
				model.addAttribute("reply" , userService.myOrdered(orderInfo).getReplyEnum());			
			}else {
				model.addAttribute("reply" , null);
			}
		}
		
	}
	
	@GetMapping("/replyWrite")	//proInfo 에서 넘어와서 reply_insert 후 다시 proInfo로 넘어갈 때 작성자 value 가 안뜸
								// ${user.userName} 에서 ${member.userName} 로 바꾸니 해결 
								// ${user.userName} 은 왜 1회성으로만 값을 넘기는 것인가?
	
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
	public void getMyInfo(@RequestParam(value="n" , required=false) String string, Model model , UserDto dto) throws Exception {
		logger.info("My Info");
		System.out.println("My Info");
		dto.setUserId(string);
		model.addAttribute("user", userService.myInfo(dto));

	}

	
	@GetMapping("/userUpdate")
	public void GetUserUpdate(@RequestParam(value = "n" )String string , UserDto dto,
								Model model) throws Exception {
		logger.info("Get userUpdate");
		System.out.println("Get UserUpdate");

		System.out.println("id : " + string);
		dto.setUserId(string);
		model.addAttribute("info" , userService.myInfo(dto));
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
							,OrderInfo orderInfo , Model model , UserDto dto ,Product pro) throws Exception {
		logger.info("Get OrderPage");
		System.out.println("Get OrderPage");	
		// 주문정보 中 회원정보 넣어주기
		dto.setUserId(string);
		model.addAttribute("member" , userService.myInfo(dto));

		System.out.println("test : " + userService.myInfo(dto).getUserId());
		System.out.println("test : " + userService.myInfo(dto).getUserName());
		System.out.println("test : " + userService.myInfo(dto).getUserPhone());
		System.out.println("test : " + userService.myInfo(dto).getAddress());
		
		// 주문정보 中 상품정보 넣어주기
		model.addAttribute("pro" , adminService.proView(bno));

		System.out.println("orderEntity userId : " + userService.myInfo(dto).getUserId()); //proCode , address
		System.out.println("orderEntity proCode : " +adminService.proView(bno).getProCode() );
		System.out.println("orderEntity userId : " + userService.myInfo(dto).getAddress()); //proCode , address
	}

	@PostMapping("orderPage")
	public String postOrderPage(@RequestParam("n") String string 
								,@RequestParam("bno") int bno
								,OrderInfo orderInfo , Model model , UserDto dto , Address address
								, BindingResult bindingResult , Product pro
								,DeliverySituation userEnum , PermissionToComment ptc) throws Exception {
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
		
		// 주문 한 수량 가저오기

		//address 정보 보기
		address.setUserId(userService.myInfo(dto).getUserId());
		orderInfo.setDeliveryInfo(userEnum.Ready);
		System.out.println("userVerify : " + userService.myInfo(dto).getVerify());
		System.out.println("enum class test : " + orderInfo.getDeliveryInfo());

		System.out.println("address userId : " + address.getUserId());
		System.out.println("address Code : " + address.getAddressCode());
		System.out.println("address streetAddress : " + address.getStreetAddress());
		System.out.println("address Address : " + address.getAddress());
		System.out.println("address details : " + address.getDetails());
		System.out.println("address ReferenceInfo : " + address.getReferenceInfo());

		
		
		
		addressService.insertAddress(address);
		//
		// 후기 권한 On

//		if(order == true) {	// 주문이 성공하면
//		return "main" or "myInfo";
//	}else if(order == false) {
//		//주문 실패 예시 찾아복;
//		System.out.println("주문이 실패하였습니다.");
//		return "proInfo";

		// 상품 수량 minus
		System.out.println("proCode : " + orderInfo.getProCode());
		System.out.println("proStock : " + orderInfo.getOrderStock());
		adminService.minusProStock(orderInfo);
		return "redirect:/main?n="+string;
	}

//	@GetMapping("/주문 완료 페이지")
//	public void 주문완료_페이지(Order order) throws Exception {
//		}
//	}



	@GetMapping("/deliveryInfo")
	public void getDeliveryInfo(@RequestParam(value="n" , required=false) String string
								,OrderInfo orderInfo , UserDto dto , Model model) throws Exception {
		logger.info("Get DeliveryInfo");
		System.out.println("Get DeliveryInfo");

		// 주문정보에 주문한 상품과 회원정보를 담는 코드 
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

		System.out.println("넘어온 주문 아이디 : " + orderId );
		System.out.println("넘어온 아이디 : " + userId);
		System.out.println("넘어온 proCode : " + proCode);
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
							,UserDto dto , OrderInfo orderInfo 
							, DeliverySituation ds , PermissionToComment ptc) throws Exception {
		logger.info("Post Refund");
		System.out.println("Post Refund");
		System.out.println("userId : " + userId); // -> 안넘어옴
		System.out.println("orderId : " + orderId);
		System.out.println("proCode   : " + proCode);
		// 후기 기능 삭제
		 
		// amdin -> client.claim -> 환불요청 띄우기 
//		adminService.userClaim(orderInfo).setDeliveryInfo(d.request_refund);

		// user -> deliveryInfo -> 배송  상황 = stop_for_refund 변경
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
					    ,DeliverySituation ds , PermissionToComment ptc) throws Exception {
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
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
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
