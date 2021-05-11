package com.sh.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

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

import com.sh.Dto.OrderInfo;
import com.sh.Dto.Product;
import com.sh.Dto.UserDto;
import com.sh.Enum.DeliverySituation;
import com.sh.Service.AdminService;
import com.sh.Service.UserService;
import com.sh.utils.UploadFileUtils;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired AdminService adminService;
	@Autowired UserService userService;
	   
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	
	@GetMapping("/chart/dayPay")
	public void getDayPay() {}
	@GetMapping("/chart/monthPay")
	public void getMonthPay() {}
	
	@GetMapping("/chart/gender")
	public void getGenderChart(Model model) throws Exception {
		System.out.println("chart");
		System.out.println("남자성비 : "+adminService.pickM());
		System.out.println("여자성비 : "+adminService.pickG());
		
		model.addAttribute("M" , adminService.pickM());
		model.addAttribute("G" , adminService.pickG());
	}
	
	
	@GetMapping("/index")
	public void getIndex() throws Exception{
		logger.info("Get Index");
	}
	
	@RequestMapping(value = "userList"  , method = RequestMethod.GET)
	public String getUserList(Model model) throws Exception{
		logger.info("Get UserList");
		System.out.println("Get UserList");
		
		model.addAttribute("userlist" , adminService.userList());
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
		System.out.println("imgUploadPath : " + imgUploadPath);
		System.out.println("ymdPath : " + ymdPath);
		
		if(file != null) {
			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

		pd.setProImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		pd.setProThumbnail(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		
		System.out.println("proImg : " + pd.getProImg());
		System.out.println("proThumbnail : " + pd.getProThumbnail());
		
		String proImg = pd.getProImg();
		String proThumb = pd.getProThumbnail();
		
		pd.setProImg(proImg.substring(1,proImg.length()));
		pd.setProThumbnail(proThumb.substring(1,proThumb.length()));
		
		adminService.proRegister(pd);
		System.out.println("상품 등록 완료");

		return "admin/index";
	}
	
	@GetMapping("/proList")
	public String postProList(Model model) throws Exception{
		logger.info("Get proList");
		System.out.println("Get proList");
		
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
		

	@GetMapping("/reqProList") // indexOutOfBoundsException occur & reason : 
							   // numberException : for input string & reason :
								
	public void getReqProcuction(Model model) throws Exception{
		logger.info("Get reqProduction");
		System.out.println("Get reqProduction");
		adminService.reqProList().clear();
		model.addAttribute("req" , adminService.reqProList());
	}
	
	
	@GetMapping("/userInfo")
	public void getUserInfo(@RequestParam("n") String userId , Model model , UserDto dto) throws Exception{
		 logger.info("Get userInfo");
		 System.out.println("Get userInfo");
		 dto.setUserId(userId);
		 System.out.println("userId : " + userId);
		 model.addAttribute("userInfo" , adminService.userInfo(dto.getUserId())); 
		
	}
	
	
	@GetMapping("/reqRefund") 
	public void getRefund (@RequestParam(value = "n" , required = false) String n
						  ,@RequestParam(value = "orderId" , required = false) String orderId
						  , OrderInfo orderInfo ,Model model) throws Exception{
		logger.info("Get user Request Refund");
		System.out.println("Get user Request Refund");
		
		orderInfo.setUserId(n);
		orderInfo.setOrderId(orderId);
		System.out.println("set userID : " + n);
		System.out.println("set orderID: " + orderId);		
		
		model.addAttribute("reqRefund" ,userService.myOrdered(orderInfo) ); 
	}
	
	@GetMapping("/acceptRefund")
	public String acceptRefund(@RequestParam(value = "n" , required = false) String n
			  ,@RequestParam(value = "orderId" , required = false) String orderId
			  , OrderInfo orderInfo ,Model model,DeliverySituation ds)throws Exception {
		logger.info("Get acceptRefund");
		System.out.println("Get acceptRefund");
		
		orderInfo.setDeliveryInfo(ds.Success_refund);
		orderInfo.setUserId(n);
		orderInfo.setOrderId(orderId);
		userService.DsUpdate(orderInfo);
		//주문 목록에서 삭제
		adminService.DeleteOrderInfo(orderInfo);
		//채널톡에서 환불 완료 알림
		return "admin/reqProList";
	}
	
	@GetMapping("/disallowRefund")	// 환불 불허
	public String disallowRefund(@RequestParam(value = "n" , required = false) String n
			  ,@RequestParam(value = "orderId" , required = false) String orderId
			  , OrderInfo orderInfo ,Model model,DeliverySituation ds)throws Exception {
		logger.info("Get disallowRefund");
		System.out.println("Get disallowRefund");

		orderInfo.setDeliveryInfo(ds.GOING);
		orderInfo.setUserId(n);
		orderInfo.setOrderId(orderId);
		userService.DsUpdate(orderInfo);
		// 채널톡을 이용한 유저에게 불허 알림 
		
		return "redirect:/admin/reqProList";
	}
	
	
	
	
	
	

	
	
	
	@GetMapping("/reqChange") 
	public void getChange (@RequestParam(value = "n" , required = false) String n
						  ,@RequestParam(value = "orderId" , required = false) String orderId
						  , OrderInfo orderInfo ,Model model) throws Exception{
		logger.info("Get user Request Change");
		System.out.println("Get user Request Change");

		System.out.println("넘어온 아이디  : " + n);
		System.out.println("넘어온 주문번호 : " + orderId);
		orderInfo.setUserId(n);
		orderInfo.setOrderId(orderId);
		
		model.addAttribute("reqChange" ,userService.myOrdered(orderInfo) ); 

	}

	@GetMapping("/acceptChange")
	public String acceptChange(@RequestParam(value = "n" , required = false) String n
			  ,@RequestParam(value = "orderId" , required = false) String orderId
			  , OrderInfo orderInfo ,Model model,DeliverySituation ds)throws Exception {
		logger.info("Get acceptChange");
		System.out.println("Get acceptChange");
		
		orderInfo.setDeliveryInfo(ds.Success_Change);
		orderInfo.setUserId(n);
		orderInfo.setOrderId(orderId);
		userService.DsUpdate(orderInfo);
		System.out.println("1"+orderInfo.getDeliveryInfo());
		System.out.println("2"+orderInfo.getUserId());
		System.out.println("3"+orderInfo.getOrderId());
		//주문 목록에서 삭제
		adminService.DeleteOrderInfo(orderInfo);
		//채널톡에서 교환 승인 알림
		return "admin/reqProList";

	}
	@GetMapping("/disallowChange")	// 교환 불허
	public String disallowChange(@RequestParam(value = "n" , required = false) String n
			  ,@RequestParam(value = "orderId" , required = false) String orderId
			  , OrderInfo orderInfo ,Model model,DeliverySituation ds)throws Exception {
		logger.info("Get disallowChange");
		System.out.println("Get disallowChange");
		
		orderInfo.setDeliveryInfo(ds.GOING);
		orderInfo.setUserId(n);
		orderInfo.setOrderId(orderId);
		userService.DsUpdate(orderInfo);
		System.out.println("1"+orderInfo.getDeliveryInfo());
		System.out.println("2"+orderInfo.getUserId());
		System.out.println("3"+orderInfo.getOrderId());

		// 채널톡을 이용한 유저에게 불허 알림 
		return "redirect:/admin/reqProList";

	}

	
	
	
	
	
	
	
	
	
	@GetMapping("/reqCancel") 
	public void getCancel (@RequestParam(value = "n" , required = false) String n
						  ,@RequestParam(value = "orderId" , required = false) String orderId
						  , OrderInfo orderInfo ,Model model) throws Exception{
		logger.info("Get user Request Cancel");
		System.out.println("Get user Request Cancel");

		System.out.println("넘어온 아이디  : " + n);
		System.out.println("넘어온 주문번호 : " + orderId);		
		orderInfo.setUserId(n);
		orderInfo.setOrderId(orderId);

		model.addAttribute("reqCancel" ,userService.myOrdered(orderInfo) ); 

	}
	
	
	@GetMapping("/acceptCancel")
	public String acceptCancel(@RequestParam(value = "n" , required = false) String n
			  ,@RequestParam(value = "orderId" , required = false) String orderId
			  , OrderInfo orderInfo ,Model model,DeliverySituation ds)throws Exception {
		logger.info("Get acceptCancel");
		System.out.println("Get acceptCancel");

		orderInfo.setDeliveryInfo(ds.Success_delivery_Cancel);
		orderInfo.setUserId(n);
		orderInfo.setOrderId(orderId);
		userService.DsUpdate(orderInfo);
		System.out.println("1"+orderInfo.getDeliveryInfo());
		System.out.println("2"+orderInfo.getUserId());
		System.out.println("3"+orderInfo.getOrderId());

		//주문 목록에서 삭제
		adminService.DeleteOrderInfo(orderInfo);
		//채널톡에서 교환 승인 알림
		return "admin/reqProList";

	}

	
}