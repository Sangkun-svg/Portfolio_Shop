package com.sh.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sh.Dto.Product;
import com.sh.Service.AdminService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired AdminService adminService;
	
	@GetMapping("/index")
	public void getIndex() throws Exception{
		logger.info("Get Index");
	}
	
	@RequestMapping(value = "userList"  , method = RequestMethod.GET)
	public String getUserList(Model model) throws Exception{
		logger.info("Get UserList");
		System.out.println("Get UserList");
		
		model.addAttribute("userlist" , adminService.userList());
		System.out.println("model 작동");
		return "userList";
	}
	
	@GetMapping("/proRegister")
	public void getRegister() throws Exception{
		logger.info("Get Register");
		System.out.println("Get Register");
	}
	
	@PostMapping("/proRegister")
	public String postRegister(Product pd) throws Exception{
		logger.info("Post Register");
		System.out.println("Post Register");

		adminService.proRegister(pd);
		System.out.println("상품 등록 완료");
		return"redirect:/proList";
	}
	
	@GetMapping("/proList")
	public String postProList(Model model) throws Exception{
		logger.info("Post proList");
		System.out.println("Post proList");

		model.addAttribute("proList" , adminService.proList());
		
		return"proList";
	}
	
}