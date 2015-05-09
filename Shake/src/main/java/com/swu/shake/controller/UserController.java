package com.swu.shake.controller;

import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.swu.shake.model.User;
import com.swu.shake.service.UserService;
import com.swu.shake.util.MD5Util;

//标识为控制层
@Controller
public class UserController {
	private UserService userService;
	private MD5Util md5Util;

	public UserService getUserService() {
		return userService;
	}

	// 注入userservice
	@Resource(name = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Resource(name = "md5Util")
	public void setMd5Util(MD5Util md5Util) {
		this.md5Util = md5Util;
	}

	public MD5Util getMd5Util() {
		return md5Util;
	}

	// 前台请求到/user/login.do的时候会加载到这里
	@RequestMapping("/user/login")
	public ModelAndView userLogin(HttpServletRequest request,
			HttpSession session) throws Exception {

		ModelAndView mav = new ModelAndView();// 新建视图
		mav.setViewName("/user/login");
		return mav;
	}

	@RequestMapping("/user/login.do")
	public ModelAndView userLoginDo(HttpServletRequest request,
			HttpSession session) throws Exception {

		String name = request.getParameter("uname");

		String unPassword = request.getParameter("psw");
		String password = MD5Util.getMD5(unPassword);
		ModelAndView mav = new ModelAndView();// 新建视图
		View v = new View() {
			@Override
			public void render(Map<String, ?> model,
					HttpServletRequest request, HttpServletResponse response)
					throws Exception {
				// TODO Auto-generated method stub

			}

			@Override
			public String getContentType() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		try {
			User u = userService.login(name, password);
			if (null != user) {
				session.setAttribute("user", user);
				mav.setViewName("/comm/success");// 返回到success.jsp中
				mav.addObject("user", user);
			} else {
				mav.setViewName("/user/login");
			}

		} catch (IndexOutOfBoundsException e) {
			mav.setViewName("index");
		}

		return mav;
	}

	public ModelAndView userRegister(HttpServletRequest quest,
			HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();

		User user = new User();

		return mav;

	}

	@RequestMapping("/user/test")
	public void test(WebRequest request) {
		Iterator i = request.getHeaderNames();
		while (i.hasNext()) {
			String name = (String) i.next();
			String value = request.getHeader(name);
			System.out.println(value);
		}
	}

}
