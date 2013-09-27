package com.hanyun.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hanyun.model.impl.User;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		 HttpServletRequest request = (HttpServletRequest) arg0;
		 HttpServletResponse response = (HttpServletResponse) arg1;
		 RequestDispatcher dispatcher = request.getRequestDispatcher("../404.jsp");
		 HttpSession session = request.getSession(true);
		 User user = (User) session.getAttribute("user");
		 String requestURI = ((HttpServletRequest) arg0).getRequestURI();
		 
		 if (null == user) {
			 // 没有登录
			 if (request != null && requestURI.contains("avatar")) {
				  arg2.doFilter(arg0, arg1);
			 } else {
				 dispatcher.forward(arg0, arg1);
				 response.setHeader("Cacha-Control", "no-store");
				 response.setDateHeader("Expires", 0);
				 response.setHeader("Pragma", "no-cache");//no-cache指示请求或响应消息不能缓存
			 }
		 } else {
			  arg2.doFilter(arg0, arg1);
		 }		 

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
