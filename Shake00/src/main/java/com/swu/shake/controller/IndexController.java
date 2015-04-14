package com.swu.shake.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@RequestMapping("/index")
	public ModelAndView Show(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		System.out.println("01:" + request.getContentLength());
		System.out.println("02:" + request.getContentType());
		System.out.println("03:" + request.getContextPath());
		System.out.println("04:" + request.getLocalAddr());
		System.out.println("05:" + request.getLocalName());
		System.out.println("06:" + request.getLocalPort());
		System.out.println("07:" + request.getMethod());
		System.out.println("08:" + request.getPathInfo());
		System.out.println("09:" + request.getPathTranslated());
		System.out.println("10:" + request.getProtocol());
		System.out.println("11:" + request.getQueryString());
		System.out.println("12:" + request.getRemoteAddr());
		System.out.println("13:" + request.getRemoteHost());
		System.out.println("14:" + request.getRemotePort());
		System.out.println("15:" + request.getRemoteUser());
		System.out.println("16:" + request.getRequestedSessionId());
		System.out.println("17:" + request.getRequestURI());
		System.out.println("18:" + request.getRequestURL());
		System.out.println("19:" + request.getScheme());
		System.out.println("20:" + request.getServerName());
		System.out.println("21:" + request.getServerPort());
		System.out.println("22:" + request.getServletPath());
		mav.setViewName("index");// 系统自己会到webinfo下面找index.jsp
		return mav;
	}
}
