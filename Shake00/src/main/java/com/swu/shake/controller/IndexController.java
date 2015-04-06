package com.swu.shake.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.swu.shake.model.User;
import com.swu.shake.service.UserService;

//标识为控制层
@Controller
public class IndexController {
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	// 注入userservice
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 匹配用户的请求，当输入localhost:8080/shake/index.do,自动匹配到里面
	@RequestMapping("/index")
	public ModelAndView Show(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");// 系统自己会到webinfo下面找index.jsp
		return mav;
	}

	// 前台请求到login.do的时候会加载到这里
	@RequestMapping("/user/login")
	public ModelAndView userLogin(HttpServletRequest request,
			HttpSession session) throws Exception {
		String name = request.getParameter("uname");
		String password = request.getParameter("psw");
		System.out.println(name + password);
		ModelAndView mav = new ModelAndView();// 新建视图
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		try {
			User u = userService.login(name, password);
			if (null != user) {
				session.setAttribute("user", user);
				mav.setViewName("comm/success");// 返回到susscc.jsp中
				mav.addObject("user", user);
			} else {
				mav.setViewName("index");
			}

		} catch (IndexOutOfBoundsException e) {
			mav.setViewName("index");
		}

		return mav;
	}
}
