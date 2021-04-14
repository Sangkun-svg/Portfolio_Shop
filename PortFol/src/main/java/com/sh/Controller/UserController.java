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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sh.Dto.OrderInfo;
import com.sh.Dto.Product;
import com.sh.Dto.ReplyDto;
import com.sh.Dto.UserDto;
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
	public String postSignin(UserDto dto , HttpServletRequest req , RedirectAttributes rttr)throws Exception {
		logger.info("Post Signin");
		System.out.println("Post Signin");

		UserDto login = userService.signin(dto);
		System.out.println("login : " + login);
		System.out.println("권한 : " + login.getVerify());
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
		return"redirect:/";
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
	public void getMainPage( Model model,HttpServletRequest req , UserDto dto) throws Exception {
		logger.info("Main Page");
		System.out.println("MainPage");
		model.addAttribute("prolist", adminService.proList());

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
	public void getProInfo(@RequestParam("n") int bno ,Model model , Product pro ) throws Exception {
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
	public void getMyInfo(UserDto dto) throws Exception {
		logger.info("My Info");
		System.out.println("My Info");
	}

	@GetMapping("/deliveryInfo")
	public void getDeliveryInfo(OrderInfo orderInfo) throws Exception {
		logger.info("Get DeliveryInfo");
		System.out.println("Get DeliveryInfo");
		// 주문정보에 주문한 상품과 회원정보를 담는 코드 
		orderInfo.setOrderId("1");
		System.out.println("orderInfo_userId : " + orderInfo.getUserId());
		System.out.println("orderInfo_userId : " + orderInfo.getProCode());
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
	public void getOrderPage(@RequestParam("n") String string , OrderInfo orderInfo ) throws Exception {
		logger.info("Get OrderPage");
		System.out.println("Get OrderPage");	
		// 주문하기 버튼 누른 후 
		// 주문 정보를 DB에 담는다
		int proCode2 = 1;	// 상품번호를 가져왔다고 치자 
		orderInfo.setUserId(string);
		orderInfo.setProCode(proCode2);
		System.out.println("myInfo :" + userService.myInfo(string));
		System.out.println("getUserId : "+orderInfo.getUserId());
		System.out.println("getProCode : "+orderInfo.getProCode());
//		orderService.order(orderInfo);
		orderService.orderinto(orderInfo);
		System.out.println("orderInfo : " + orderService.orderinto(orderInfo).getOrderId());
		System.out.println("orderInfo : " + orderService.orderinto(orderInfo).getOrderPrice());
 
		//주문정보 中 proCode , orderStock , orderPrice 
		
		
		
		
		// 상세 주소를 DB에 담는다
		// myInfo -> deliveryInfo.jsp 에 주문한 정보를 띄운다
	}
	
}
