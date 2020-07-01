package com.hqyj.yiqing.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hqyj.yiqing.pojo.TestInfo;

public interface TestInfoDao {
	//国外疫情实时统计
	//查询现存确诊
	int selectCurrentConfirmedCount();
	//查询累计确诊
	int selectConfirmCount();
	//查询治愈人数
	int selectCuredCount();
	//查询死亡人数
	int selectDeadCount();
	//查询疫情最严重的国家
	String selectWorstCountry();
	//查询疫情最轻的国家
	String selectBestCountry();
	//查询所有国家的疫情数据
	List<TestInfo> selectForeignCountYiqing();
	//查询所有国家的名称
	List<TestInfo> selectForeignPName();
	//根据用户选中国家查询该国的疫情
	TestInfo selectForeignYiqingByPName(@Param("pName") String name);
	//查询全世界前五国家的确诊信息
	List<TestInfo> selectForeignFiveConfrim();
	//查询全世界前五国家的治愈信息
	List<TestInfo> selectForeignFiveCured();
	//查询全世界前五国家的死亡信息
	List<TestInfo> selectForeignFiveDead();
	//查询近一周的疫情数据
	List<TestInfo> selectForeignYiqingInWeeks();
}
