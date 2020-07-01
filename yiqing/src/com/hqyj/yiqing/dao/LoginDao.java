package com.hqyj.yiqing.dao;

import org.apache.ibatis.annotations.Param;

import com.hqyj.yiqing.pojo.UserInfo;

public interface LoginDao {
	
	//定义登录方法
	UserInfo login(@Param("userName") String name,@Param("userPwd")String pwd);
	//定义注册方法
    int regedit(@Param("userName") String name,@Param("userPwd")String pwd);
    //定义验证注册是否重名
    UserInfo valReName(@Param("userName") String name);
}
