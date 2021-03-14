package com.sh.Controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sh.Dto.UserDto;
import com.sh.Service.UserService;

@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	private UserService userService;
	
	@GetMapping("/signup")
	public void getSignUp() {
		logger.info("Get SignUp ");
	}
	
	@PostMapping
	public String postSignUp(UserDto dto) throws Exception{
		logger.info("Post SignUp ");
		
		userService.register(dto);
		
		return"redirect:/";
	}
	
	@GetMapping("/signin")
	public void getSignup()throws Exception{
		logger.info("Get Signin");
	}
	
	@PostMapping("/signin")
	public String postSignup(UserDto dto , HttpServletRequest req , RedirectAttributes rttr)throws Exception {
		logger.info("Post Signin");
		
		UserDto login = userService.signin(dto);
		HttpSession session = req.getSession();
		
		if(login != null) {
			session.setAttribute("member", login);
			System.out.println("Login Success");
		}else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg" , false);
		}
		return"redirect:/";
	}
	
	@GetMapping("/signout")
	public String signout(HttpSession session)throws Exception {
		logger.info("SignOut");
		
		userService.signout(session);
		return"redirect:/";
	}
	
}