package com.hqyj.yiqing.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.yiqing.dao.InfoDao;
import com.hqyj.yiqing.pojo.Info;



@Service
public class InfoServiceImpl implements InfoService{
	
	//创建一个墩子对象
	@Autowired
	private InfoDao dao;

	@Override
	public int selectConfirmCountSum() {
		//拿到墩子切的菜
		int num = dao.selectConfirmCountSum();
		return num;
	}

	@Override
	public List<HashMap<String, Object>> selectCurYingqing() {
		//确诊人数
		int confirmNum = dao.selectConfirmCountSum();
		//治愈人数
		int curedNum = dao.selectCuredCountSum();
		//死亡人数
		int deadNum = dao.selectDeadCountSum();
		
		//创建一个集合对象
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		
		//构建现有确诊的数据格式
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "现有确诊");
		map.put("value", confirmNum);
		list.add(map);
		
		//构建治愈人数的数据格式
		HashMap<String, Object> mapCure = new HashMap<String, Object>();
		mapCure.put("name", "现有治愈");
		mapCure.put("value", curedNum);
		list.add(mapCure);
		
		//构建死亡人数的数据格式
		HashMap<String, Object> mapDead = new HashMap<String, Object>();
		mapDead.put("name", "现有死亡");
		mapDead.put("value", deadNum);
		list.add(mapDead);
		
		return list;
	}

	@Override
	public List<Info> selectPname() {
		// TODO Auto-generated method stub
		return dao.selectPname();
	}

	@Override
	public List<HashMap<String, Object>> selectyiqingByPName(String name) {

		Info info = dao.selectyiqingByPName(name);
		//创建一个集合对象
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		
		//构建现有确诊的数据格式
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "现有确诊");
		map.put("value", info.getConfirmCount());
		list.add(map);
		
		//构建治愈人数的数据格式
		HashMap<String, Object> mapCure = new HashMap<String, Object>();
		mapCure.put("name", "现有治愈");
		mapCure.put("value", info.getCuredCount());
		list.add(mapCure);
		
		//构建死亡人数的数据格式
		HashMap<String, Object> mapDead = new HashMap<String, Object>();
		mapDead.put("name", "现有死亡");
		mapDead.put("value", info.getDeadCount());
		list.add(mapDead);
		return list;
	}

	@Override
	public List<HashMap<String, Object>> selectCountYiqing() {
		//获取34个省市自治区的疫情数据
		List<Info> list = dao.selectPname();
		
		//创建一个地图数据集合
		List<HashMap<String, Object>> listMap = new ArrayList<HashMap<String, Object>>();
		//构建中国地图需要的数据格式
		for(Info info:list){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("name", info.getProvinceName());
			map.put("value", info.getConfirmCount());
			listMap.add(map);
		}
		return listMap;
	}

	@Override
	public List<HashMap<String, Object>> selectCountYiqingByPName(String name) {
		//获取查询省市自治区的疫情数据
		List<Info> list = dao.selectCountYiqingByPName(name);
		
		//创建一个地图数据集合
		List<HashMap<String, Object>> listMap = new ArrayList<HashMap<String, Object>>();
		//构建中国地图需要的数据格式
		for(Info info:list){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("name", info.getAreaName());
			map.put("value", info.getConfirmCount());
			listMap.add(map);
		}
		return listMap;
	}

	@Override
	public HashMap<String, Object> selectFiveConfrimByPName(String name) {
		List<Info> list = dao.selectFiveConfrimByPName(name);
		//创建一个map对象
		HashMap<String, Object> map = new HashMap<String, Object>();
		//构建柱状图需要的数据格式
		if (null != list&& list.size()>0){
			//构建前五的地区名称
			List<String> listAreaName = new ArrayList<>();
			//构建前五的确诊数据
			List<Integer> listData = new ArrayList<>();
			for(Info info:list){
				listAreaName.add(info.getAreaName());
				listData.add(info.getConfirmCount());
			}
			map.put("area", listAreaName);
			map.put("data",listData);
			//构建时间
			map.put("time", list.get(0).getTime());
		}
		return map;
	}

	@Override
	public HashMap<String, Object> selectFiveCuredByPName(String name) {
		List<Info> list = dao.selectFiveCuredByPName(name);
		//创建一个map对象
		HashMap<String, Object> map = new HashMap<String, Object>();
		//构建柱状图需要的数据格式
		if (null != list&& list.size()>0){
			//构建前五的地区名称
			List<String> listAreaName = new ArrayList<>();
			//构建前五的确诊数据
			List<Integer> listData = new ArrayList<>();
			for(Info info:list){
				listAreaName.add(info.getAreaName());
				listData.add(info.getConfirmCount());
			}
			map.put("area", listAreaName);
			map.put("data",listData);
			//构建时间
			map.put("time", list.get(0).getTime());
		}
		return map;
	}

	@Override
	public HashMap<String, Object> selectFiveDeadByPName(String name) {
		List<Info> list = dao.selectFiveDeadByPName(name);
		//创建一个map对象
		HashMap<String, Object> map = new HashMap<String, Object>();
		//构建柱状图需要的数据格式
		if (null != list&& list.size()>0){
			//构建前五的地区名称
			List<String> listAreaName = new ArrayList<>();
			//构建前五的确诊数据
			List<Integer> listData = new ArrayList<>();
			for(Info info:list){
				listAreaName.add(info.getAreaName());
				listData.add(info.getConfirmCount());
			}
			map.put("area", listAreaName);
			map.put("data",listData);
			//构建时间
			map.put("time", list.get(0).getTime());
		}
		return map;
	}

}
