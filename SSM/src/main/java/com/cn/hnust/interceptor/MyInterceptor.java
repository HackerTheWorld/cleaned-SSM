package com.cn.hnust.interceptor;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cn.hnust.filter.MyFilter;
import com.cn.hnust.pojo.LoginEntity;
import com.cn.hnust.service.ILoginService;

public class MyInterceptor implements HandlerInterceptor{

	@Resource
	private ILoginService loginservice;
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger(MyFilter.class.getName());
		if(req.getMethod()=="post") {
			logger.info("get");
			return false;
		}else {
			logger.info("post:"+req.getParameter("method"));
		}
		String token = req.getParameter("token");
		LoginEntity loginentity  = loginservice.asToken(token);
		if(loginentity == null) {
			logger.info("don't have this token");
			return false; 
		}else {
			return true;
		}
	}

}
