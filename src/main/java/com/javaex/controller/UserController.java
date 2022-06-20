package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@Repository
public class UserController {
	//필드
	@Autowired
	UserService userService;
	//생성자
	//메소드gs
	//메소드일반
	
	//로그인폼
	@RequestMapping(value="/user/loginForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("UserController >> loginForm()");
		
		return "user/loginForm";
	}
	
	//회원가입폼
	@RequestMapping(value="/user/joinForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("UserController >> joinForm()");
		
		return "user/joinForm";
	}
	
	@RequestMapping(value="/user/join", method = {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("UserController >> join()");
		
		
		userService.join(userVo);
		
		return "user/joinOk";
	}
}
