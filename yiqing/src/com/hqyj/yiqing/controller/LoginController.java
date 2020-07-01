package com.hqyj.yiqing.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.yiqing.service.LoginService;

/**
 * 通俗讲：服务员类
 * 框架讲：控制器类
 * @author DELL
 *
 */
@Controller
@RequestMapping("login")
public class LoginController {
	
	//创建一个厨师对象
	@Autowired
	private LoginService service;

	//登录方法
	//端菜给顾客
	@RequestMapping("huiguorou.do")
	public String login(@RequestParam("userName")String name,@RequestParam("userPwd") String pwd,HashMap  map){
		
		return service.loginForm(name, pwd, map);
		
	}
	
	//ajax登录
	@RequestMapping("loginAjax.do")
	@ResponseBody
	public String loginAjax(@RequestParam("userName")String name,@RequestParam("userPwd") String pwd){
		return service.login(name, pwd);
	}
	
	//注册方法
	@RequestMapping("regedit.do")
	@ResponseBody
	public String regedit(@RequestParam("userName")String name,@RequestParam("userPwd") String pwd){
		//
		return service.regedit(name, pwd);
	}
	//验证重名
	@RequestMapping("valReName.do")
	@ResponseBody
	public boolean valReName(@RequestParam("userName")String name){
		//
		return service.valReName(name);
	}
}
