package com.sh.Controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
}
