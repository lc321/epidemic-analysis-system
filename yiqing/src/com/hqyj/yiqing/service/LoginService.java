package com.hqyj.yiqing.service;

import java.util.HashMap;

public interface LoginService {
	//ajax登录查询
	String login(String userName,String userPwd);
	//表单登录查询
	String loginForm(String userName,String userPwd,HashMap  map);
	
	//注册
	String regedit(String userName,String userPwd);
	//验证重名
	boolean valReName(String userName);

	
}
