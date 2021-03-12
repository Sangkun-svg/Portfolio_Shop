package com.sh.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sh.Dto.UserDto;

public class AdminInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj)
			throws Exception {
		
		HttpSession session = req.getSession();
		UserDto member = (UserDto)session.getAttribute("member");
		
		if(member == null) {
			res.sendRedirect("/www/signin");
			return false;
		}
		
		if(member.getVerify() != 9 ) {
			res.sendRedirect("/");
			return false;
		}
		
		return super.preHandle(req, res, obj);
	}

}
