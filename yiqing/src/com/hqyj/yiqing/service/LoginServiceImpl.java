package com.hqyj.yiqing.service;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.yiqing.dao.LoginDao;
import com.hqyj.yiqing.pojo.UserInfo;

//告诉spring他是一个服务类，厨师角色
@Service
public class LoginServiceImpl implements LoginService{

	//创建一个墩子
	@Autowired
	private LoginDao dao;
	
	@Override
	public String login(String userName, String userPwd) {
		//访问dao的查询方法,拿到墩子切的菜
		UserInfo user = dao.login(userName, userPwd);
		if(user==null){
			return "fail";
		}
		return "success";
	}

	@Override
	public String loginForm(String userName, String userPwd, HashMap map) {
		//访问dao的查询方法,拿到墩子切的菜
		UserInfo user = dao.login(userName, userPwd);
		
		if(user==null){
			map.put("info", "用户名和密码输入错误");
			return "/index.jsp";
		}
		return "/test.jsp";
	}

	@Override
	public String regedit(String userName, String userPwd) {
		//获取注册的菜
		int num = dao.regedit(userName, userPwd);
		//判断注册是否成功
		if(num ==1){
			return "success";
		}
				
		return "fail";
	}

	@Override
	public boolean valReName(String userName) {
		//拿到验证重名的菜
		UserInfo user = dao.valReName(userName);
		//判断是否重名
		if (user!=null){
			return true;
		}
		return false;
	}

}
