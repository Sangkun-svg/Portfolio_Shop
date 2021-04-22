package com.sh.Controller;

import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.sh.Dto.Address;
import com.sh.Dto.OrderInfo;
import com.sh.Dto.Product;
import com.sh.Dto.ReplyDto;
import com.sh.Dto.UserDto;
import com.sh.Enum.DeliverySituation;
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
				System.out.println("암호화 전 비밀번호 : " + dto.getUserPass());
				String encryPassword = UserSha256.encrypt(dto.getUserPass());
				dto.setUserPass(encryPassword);
				System.out.println("암호화 후 비밀번호 : " + dto.getUserPass());
				
				userService.register(dto);
			}
		}catch (Exception e) {

		}
		
		return"redirect:/";
	}
	
	@GetMapping("/signin")
	public void getSignup()throws Exception{
		logger.info("Get Signin");
		System.out.println("Get Signin");
	}
	
	@PostMapping("/signin")
	public String postSignin(UserDto dto , HttpServletRequest req , RedirectAttributes rttr , Model model)throws Exception {
		logger.info("Post Signin");
		System.out.println("Post Signin");
		String test = dto.getUserId();
		System.out.println("dto.userID : " + dto.getUserId());
		System.out.println("dto.userPass : " + dto.getUserPass());
		UserDto login = userService.signin(dto);
		
		System.out.println("login : " + login);
		System.out.println("userId : " + dto.getUserId());
		model.addAttribute("user" , userService.myInfo(dto));

		HttpSession session = req.getSession();

		
		String encryPassword = UserSha256.encrypt(dto.getUserPass());
		dto.setUserPass(encryPassword);
		System.out.println(dto.getUserPass());
				
		// 작동 안하는 이유는 mapper에 result 타입에 들어가지 않아서 이다????
		// -> 1. DB 안에서 update 사용해서 id pass 만들고 로그인 시도
		// -> 2. mapper.signup에 resultType을 Dto로 설정 해보기 
		// -> 로그인 실패시  login : null
		// -> 로그인 성공시 
		
		if(login != null) {
			session.setAttribute("member", login);
			System.out.println("Login Success");
			System.out.println("session : " + session);
		}else {
			System.out.println("입력한 비밀번호 : " + dto.getUserPass());			
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg" , false);
			System.out.println("Login false");
		}
		return"redirect:/nav?n="+test;
	}
	
	
	@GetMapping("/signout")
	public String signout(HttpSession session)throws Exception {
		logger.info("SignOut");

		userService.signout(session);
		System.out.println("SignOut");
		
		return"redirect:/main";
	}

	@GetMapping("/userDelete")
	public void GetUserDelete() throws Exception{
		logger.info("Get userDelete");
		System.out.println("Get UserDelete");
	}
	@PostMapping("/userDelete")
	public String PostUserDelete(UserDto dto , HttpSession session , RedirectAttributes rttr	) throws Exception{
		logger.info("Post userDelete");
		System.out.println("Post UserDelete");

		UserDto member = (UserDto)session.getAttribute("member");
		
		String sessionPass = member.getUserPass();
		String dtoPass = dto.getUserPass();
		
		if(!(sessionPass.equals(dtoPass))) {
			rttr.addFlashAttribute("msg" , false);
			return "redirect:/userDelete";
		}
		userService.userDelete(dto);
		session.invalidate();
		return"redirect:/"; 
	}


	@ResponseBody
	@PostMapping("passValidation")
	public int passValidation(UserDto dto) throws Exception{
		System.out.println("Post passValidation");

		int result = userService.passValidation(dto);
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
		HttpSession session = req.getSession();
		System.out.println("session : " + session );
		System.out.println("session.getId : " + session.getId());
		
		if(session.isNew() == true) {
			System.out.println(session.isNew());
			System.out.println("새로 생긴 세션");
			session = null;			
		}else {
			System.out.println(session.isNew());
			model.addAttribute("session" , session);			
		}
		
		// 여기까지
		
	}
	
	@GetMapping("/proInfo")
	public void getProInfo(@RequestParam("n") int bno ,Model model , Product pro , UserDto dto) throws Exception {
		logger.info("Get ProInfo");
		System.out.println("Get ProInfo");
		
		pro.setBno(bno);
		System.out.println("bno : " + pro.getBno());
		model.addAttribute("pro", adminService.proView(pro.getBno())); 

		List<ReplyDto> replyList = replyService.readReply(pro.getBno());
		
		model.addAttribute("replyList", replyList);
	}
	
	@GetMapping("/replyWrite")
	public String replyWrite(@RequestParam("n") int bno ,ReplyDto dto , RedirectAttributes rttr , Product pro) throws Exception {
		logger.info("Post ReplyWrite");
		System.out.println("Post ReplyWrite");
		System.out.println("pro : " + pro.getBno());
		
		bno = pro.getBno();
		
		replyService.writeReply(dto);

		rttr.addAttribute("bno" , dto.getBno());

		return"redirect:/proInfo";
	}

	@GetMapping("/myInfo")
	public void getMyInfo(@RequestParam(value="n" , required=false) String string, Model model , UserDto dto) throws Exception {
		logger.info("My Info");
		System.out.println("My Info");
		dto.setUserId(string);
		model.addAttribute("user", userService.myInfo(dto));
	}

	
	@GetMapping("/userUpdate")
	public void GetUserUpdate() throws Exception {
		logger.info("Get userUpdate");
		System.out.println("Get UserUpdate");
	}
	
	@PostMapping("/userUpdate")
	public String PostUserUpdate(UserDto dto , HttpSession session) throws Exception{
		logger.info("Post userUpdate");
		System.out.println("Post UserUpdate");

		userService.userUpdate(dto);
		session.invalidate();
		return "redirect:/";
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
//		userId , userName , userPhone , verify , address

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
								, BindingResult bindingResult ,DeliverySituation userEnum ) throws Exception {
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
		orderService.order(orderInfo);
		// 주문 한 수량 가저오기
		//enum class 세팅
			/*
			 * 1. 구매자 -> myInfo -> deliveryInfo.jsp -> Enum(배송상태).set 준비중
			 * 2. 관리자 -> admin/claim/delivery(배송상태) -> Enum.set(주문요청) -> Btn click -> 구매자 Enum.set 배달진행중
			 * 3. 관리자 -> 배송완료시 -> enum.set 배달완료
			 */
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
		//adminService.proMinusProStock Dao , Service 만들기 (Dao 나 Service로만 처리 가능 한가?)

//		if(order == true) {	// 주문이 성공하면
//		return "main" or "myInfo";
//	}else if(order == false) {
//		//주문 실패 예시 찾아복;
//		System.out.println("주문이 실패하였습니다.");
//		return "proInfo";

		
		return "redirect:/main";
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
						 , UserDto dto , Model model , OrderInfo orderInfo)throws Exception {
		logger.info("Get Refund Page");
		System.out.println("Get Refund Page");

		System.out.println("넘어온 주문 아이디 : " + orderId );
		System.out.println("넘어온 아이디 : " + userId);
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
							,UserDto dto , OrderInfo orderInfo , DeliverySituation ds) throws Exception {
		logger.info("Post Refund");
		System.out.println("Post Refund");
		System.out.println("userId : " + userId); // -> 안넘어옴
		System.out.println("orderId : " + orderId);
		// 후기 기능 삭제
		 
		// amdin -> client.claim -> 환불요청 띄우기 
//		adminService.userClaim(orderInfo).setDeliveryInfo(d.request_refund);

		// user -> deliveryInfo -> 배송상황 = stop_for_refund 변경
		orderInfo.setUserId(userId);
		orderInfo.setOrderId(orderId);
		orderInfo.setDeliveryInfo(ds.Stop_for_refund);
		userService.DsUpdate(orderInfo);
		return "redirect:/main?n="+userId;
	}
}
