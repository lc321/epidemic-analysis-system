package com.hqyj.yiqing.service;

import java.util.HashMap;
import java.util.List;

import com.hqyj.yiqing.pojo.Info;

public interface InfoService {

	int selectConfirmCountSum();
	//今日疫情分析
	List<HashMap<String,Object>> selectCurYingqing();
	//查询34个省市自治区的名称
	List<Info> selectPname();
	//各省的疫情分析
	List<HashMap<String,Object>> selectyiqingByPName(String name);
	//新冠肺炎人口来源分析
	List<HashMap<String,Object>> selectCountYiqing();
	//根据省份查询该省的疫情
	List<HashMap<String,Object>> selectCountYiqingByPName(String name);
	//查询各省前五地区的确诊信息
	HashMap<String,Object> selectFiveConfrimByPName(String name);
	//查询各省前五地区的治愈信息
	HashMap<String,Object> selectFiveCuredByPName(String name);
	//查询各省前五地区的死亡信息
	HashMap<String,Object> selectFiveDeadByPName(String name);
}
