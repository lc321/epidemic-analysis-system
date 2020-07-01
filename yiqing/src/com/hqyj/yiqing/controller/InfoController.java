package com.hqyj.yiqing.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqyj.yiqing.pojo.Info;
import com.hqyj.yiqing.service.InfoService;

@Controller//表示这是一个控制层(服务员)
@RequestMapping("info")
public class InfoController {

	//创建一个厨师对象
	@Autowired
	private InfoService service;
	//获取当天累计确诊人数
	@RequestMapping("selectConfirmCountSum.do")
	@ResponseBody
	public int selectConfirmCountSum(){
		
		return service.selectConfirmCountSum();
				
	}
	//今日疫情分析
	@RequestMapping("selectCurYingqing.do")
	@ResponseBody
	public List<HashMap<String, Object>> selectCurYingqing(){
		
		return service.selectCurYingqing();
				
	}
	//查询34个省市自治区的名称
	@RequestMapping("/selectPName.do")
	@ResponseBody
	public List<Info> selectPName(){
		
		return service.selectPname();
	}
	//各省疫情分析
	@RequestMapping("/selectyiqingByPName.do")
	@ResponseBody
	public List<HashMap<String, Object>> selectyiqingByPName(@RequestParam("pName")String name){
		return service.selectyiqingByPName(name);
	}
	
	//新冠肺炎人口来源
	@RequestMapping("/selectCountYiqing.do")
	@ResponseBody
	public List<HashMap<String, Object>> selectCountYiqing(){
		return service.selectCountYiqing();
	}
	
	//获取查询省市自治区的疫情数据
	@RequestMapping("/selectCountYiqingByPName.do")
	@ResponseBody
	public List<HashMap<String, Object>> selectCountYiqingByPName(@RequestParam("pName")String name){
		return service.selectCountYiqingByPName(name);
	}
	
	//查询各省前五地区的确诊信息
	@RequestMapping("/selectFiveConfrimByPName.do")
	@ResponseBody
	public HashMap<String, Object> selectFiveConfrimByPName(@RequestParam("pName")String name){
		return service.selectFiveConfrimByPName(name);
	}
	
	//查询各省前五地区的确诊信息
	@RequestMapping("/selectFiveCuredByPName.do")
	@ResponseBody
	public HashMap<String, Object> selectFiveCuredByPName(@RequestParam("pName")String name){
		return service.selectFiveCuredByPName(name);
	}
	
	//查询各省前五地区的确诊信息
	@RequestMapping("/selectFiveDeadByPName.do")
	@ResponseBody
	public HashMap<String, Object> selectFiveDeadByPName(@RequestParam("pName")String name){
		return service.selectFiveDeadByPName(name);
	}
}
