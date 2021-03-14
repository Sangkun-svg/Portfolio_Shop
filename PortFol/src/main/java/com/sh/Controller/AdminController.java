package com.sh.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/index")
	public void getIndex() throws Exception{
		logger.info("Get Index");
	}
	
	@GetMapping("/goods/register")
	public void getGoodsRegister() throws Exception{
		logger.info("Get goods register");
	}
}
