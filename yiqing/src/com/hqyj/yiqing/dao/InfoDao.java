package com.hqyj.yiqing.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hqyj.yiqing.pojo.Info;

public interface InfoDao {

	//查询当天的34个省市自治区的肺炎累计确诊人数
	int selectConfirmCountSum();
	//查询治愈人数
	int selectCuredCountSum();
	//查询死亡人数
	int selectDeadCountSum();
	//查询34个省市自治区的名称
	List<Info> selectPname();
	//根据用户选中省份查询该省的疫情
	Info selectyiqingByPName(@Param("pName") String name);
	//根据省份查询该省的疫情
	List<Info> selectCountYiqingByPName(@Param("pName") String name);
	//查询各省前五地区的确诊信息
	List<Info> selectFiveConfrimByPName(@Param("pName") String name);
	//查询各省前五地区的治愈信息
	List<Info> selectFiveCuredByPName(@Param("pName") String name);
	//查询各省前五地区的死亡信息
	List<Info> selectFiveDeadByPName(@Param("pName") String name);
}
