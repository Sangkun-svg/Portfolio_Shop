package com.sh.Controller;

import java.io.File;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sh.Dto.Product;
import com.sh.Service.AdminService;
import com.sh.utils.UploadFileUtils;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired AdminService adminService;
	   
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	
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
		return "admin/userList";
	}
	
	@GetMapping("/proRegister")
	public void getRegister() throws Exception{
		logger.info("Get Register");
		System.out.println("Get Register");
	}
	
	@PostMapping("/proRegister")
	public String postRegister(Product pd , MultipartFile file) throws Exception{
		logger.info("Post Register");
		System.out.println("Post Register");

		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file != null) {
			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

		pd.setProImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		pd.setProThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		
		
		adminService.proRegister(pd);
		System.out.println("상품 등록 완료");

		return "admin/index";
	}
	
	@GetMapping("/proList")
	public String postProList(Model model) throws Exception{
		logger.info("Post proList");
		System.out.println("Post proList");
		
		model.addAttribute("proList" , adminService.proList());
		
		return "admin/proList";
	}
	
	
	@GetMapping("/proUpdate")
	public void getProUpdate(@RequestParam("n") int bno , Model model , Product pro ) throws Exception {
		 logger.info("Get proUpdate");
		 System.out.println("Get proUpdate");
		 pro.setBno(bno);
		 model.addAttribute("pro", adminService.proView(pro.getBno())); 
		}	

	
	@PostMapping("/proUpdate")
	public String postProUpdate(Product pro) throws Exception{
		logger.info("Post proUpdate");
		System.out.println("Post proUpdate");

		adminService.proUpdate(pro);
		System.out.println("Update Success");
		
		return "redirect:/admin/proList";
	}
	
	@RequestMapping(value = "/proDelete" , method = {RequestMethod.GET , RequestMethod.POST})
	public String proDelete(@RequestParam("n") int bno) throws Exception{
		logger.info("Production Delete");
		System.out.println("Production Delete");
		//bno가 null 값으로 넘어와서 삭제 안되는 중 
		adminService.proDelete(bno);

		System.out.println("Delete Success");
		return "redirect:/admin/proList";
	}
	
	@GetMapping("/claim")
	public void getClaim() throws Exception{
		logger.info("Get claim");
		System.out.println("Get claim");
	}
//	sales
//	delivery
//	refund

	@GetMapping("/sales")
	public String getSales () throws Exception{
		logger.info("Get sales");
		System.out.println("Get sales");
		
		return"admin/claims/sales";
	}
	
	@GetMapping("/delivery")
	public String getDelivery () throws Exception{		
		logger.info("Get delivery");
		System.out.println("Get delivery");
		return"admin/claims/delivery";
	}
	
	@GetMapping("/refund")
	public String getRefund () throws Exception{
		logger.info("Get refund");
		System.out.println("Get refund");
		return"admin/claims/refund";
	}
	
}