package com.cn.hnust.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.cn.hnust.pojo.LoginEntity;
import com.cn.hnust.service.ILoginService;

public class MyFilter extends OncePerRequestFilter{

	@Resource
	private ILoginService loginservice;
	
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger(MyFilter.class.getName());
		if(req.getMethod()=="post") {
			logger.info("get");
			return ;
		}else {
			logger.info("post:"+req.getParameter("method"));
		}
		
		String token = req.getParameter("token");
		LoginEntity loginentity  = loginservice.asToken(token);
		if(loginentity == null) {
			logger.info("don't have this token");
			return ; 
		}else {
			chain.doFilter(req,res);
		}
		
	}

}
