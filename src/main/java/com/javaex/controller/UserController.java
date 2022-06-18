package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	//필드
	//생성자
	//메소드gs
	//메소드일반
	
	//로그인폼
	@RequestMapping(value="/loginForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("UserController >> loginForm()");
		
		return "user/loginForm";
	}
	
	//회원가입폼
	@RequestMapping(value="/joinForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("UserController >> joinForm()");
		
		return "user/joinForm";
	}
}
