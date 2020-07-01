package com.hqyj.yiqing.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.yiqing.pojo.TestInfo;
import com.hqyj.yiqing.service.TestInfoService;

@Controller//表示这是一个控制层(服务员)
@RequestMapping("testinfo")
public class TestInfoController {

	@Autowired
	private TestInfoService service;
	
	//国外疫情实时统计
	@RequestMapping("selectAllForeignYiqing.do")
	@ResponseBody
	public HashMap<String, Object> selectAllForeignYiqing(){
	
		return service.selectAllForeignYiqing();
				
	}
	
	//国外疫情人口来源分析
	@RequestMapping("selectForeignCountYiqing.do")
	@ResponseBody
	public List<HashMap<String, Object>> selectForeignCountYiqing(){
	
		return service.selectForeignCountYiqing();
				
	}
	
	//今日国外疫情分析
	@RequestMapping("selectCurForeignYiqing.do")
	@ResponseBody
	public List<HashMap<String, Object>> selectCurForeignYiqing(){
		
		return service.selectCurForeignYiqing();
				
	}
	
	//查询所有国家的名称
	@RequestMapping("/selectForeignPName.do")
	@ResponseBody
	public List<TestInfo> selectForeignPName(){
		
		return service.selectForeignPName();
	}
	
	//获取查询国家的疫情数据
	@RequestMapping("/selectForeignYiqingByPName.do")
	@ResponseBody
	public List<HashMap<String, Object>> selectCountYiqingByPName(@RequestParam("pName")String name){
		return service.selectForeignYiqingByPName(name);
	}
	
	//查询全世界前五国家的确诊信息
	@RequestMapping("/selectForeignFiveConfrim.do")
	@ResponseBody
	public HashMap<String, Object> selectForeignFiveConfrim(){
		return service.selectForeignFiveConfrim();
	}
	
	//查询全世界前五国家的治愈信息
	@RequestMapping("/selectForeignFiveCured.do")
	@ResponseBody
	public HashMap<String, Object> selectForeignFiveCured(){
		return service.selectForeignFiveCured();
	}
		
	//查询全世界前五国家的死亡信息
	@RequestMapping("/selectForeignFiveDead.do")
	@ResponseBody
	public HashMap<String, Object> selectForeignFiveDead(){
		return service.selectForeignFiveDead();
	}
	
	//显示近一周内的疫情数据selectForeignYiqingInWeeks
	@RequestMapping("/selectForeignYiqingInWeeks.do")
	@ResponseBody
	public List<HashMap<String, Object>> selectForeignYiqingInWeeks(){
		return service.selectForeignYiqingInWeeks();
	}
}
