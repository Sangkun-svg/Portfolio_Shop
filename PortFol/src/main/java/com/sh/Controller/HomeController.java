package com.sh.Controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.Dto.UserDto;
import com.sh.Service.UserService;

@Controller
public class HomeController {
	
	@Inject 
	UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/nav", method = {RequestMethod.GET,RequestMethod.POST})
	public String home(@RequestParam("n") String string ,Model model , UserDto dto ) throws Exception {
		System.out.println("Get nav");
		System.out.println("RequestParam : " + string);
		dto.setUserId(string);
		System.out.println(userService.myInfo(dto));
		System.out.println("id : " + userService.myInfo(dto).getUserId());
		System.out.println("pass : " + userService.myInfo(dto).getUserPass());
		System.out.println("name : " + userService.myInfo(dto).getUserName());
		System.out.println("phone : " + userService.myInfo(dto).getUserPhone());
		System.out.println("address : " + userService.myInfo(dto).getAddress());
		System.out.println("verify : " + userService.myInfo(dto).getVerify());
		System.out.println("joinDate : " + userService.myInfo(dto).getUserJoinDate());
//		System.out.println("verify : " + userService.myInfo(dto).getVerify());
		
		
		
		if(userService.myInfo(dto).getVerify() != 9) {
			System.out.println("go main");
			return "redirect:/main?n="+string; 
		}else {
			System.out.println("go nav");
			return "nav";
			
		}
	}
	
}
