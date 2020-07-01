package com.hqyj.yiqing.service;

import java.util.HashMap;
import java.util.List;

import com.hqyj.yiqing.pojo.TestInfo;

public interface TestInfoService {
	//国外疫情实时统计
	HashMap<String, Object> selectAllForeignYiqing();
	//查询所有国家的疫情数据
	List<HashMap<String, Object>> selectForeignCountYiqing();
	//今日疫情分析
	List<HashMap<String,Object>> selectCurForeignYiqing();
	//查询所有国家的名称
	List<TestInfo> selectForeignPName();
	//根据国家名称查询该国的疫情
	List<HashMap<String,Object>> selectForeignYiqingByPName(String name);
	//查询全世界前五国家的确诊信息
	HashMap<String,Object> selectForeignFiveConfrim();
	//查询全世界前五国家的治愈信息
	HashMap<String,Object> selectForeignFiveCured();
	//查询全世界前五国家的死亡信息
	HashMap<String,Object> selectForeignFiveDead();
	//查询近一周的疫情数据
	List<HashMap<String,Object>> selectForeignYiqingInWeeks();
}
