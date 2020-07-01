package com.hqyj.yiqing.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.yiqing.dao.TestInfoDao;
import com.hqyj.yiqing.pojo.TestInfo;

@Service
public class TestInfoServiceImpl implements TestInfoService{

	@Autowired
	private TestInfoDao testInfoDao;
	
	@Override
	public HashMap<String, Object> selectAllForeignYiqing() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("newConfirm",testInfoDao.selectCurrentConfirmedCount());
		map.put("allConfirm",testInfoDao.selectConfirmCount());
		map.put("cured",testInfoDao.selectCuredCount());
		map.put("dead",testInfoDao.selectDeadCount());
		map.put("maxPname",testInfoDao.selectWorstCountry());
		map.put("minPname",testInfoDao.selectBestCountry());
		return map;
	}

	@Override
	public List<HashMap<String, Object>> selectForeignCountYiqing() {
		//获取国外所有国家的疫情数据
		List<TestInfo> list = testInfoDao.selectForeignCountYiqing();
		
		//创建一个国外地图数据集合
		List<HashMap<String, Object>> listMap = new ArrayList<HashMap<String, Object>>();
		//构建世界地图所需要的数据格式
		for(TestInfo testinfo:list){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("name",testinfo.getProvinceName());
			map.put("value",testinfo.getCurrentConfirmedCount());
			listMap.add(map);
		}
		
		return listMap;
	}

	@Override
	public List<HashMap<String, Object>> selectCurForeignYiqing() {
		//确诊人数
		int confirmNum = testInfoDao.selectCurrentConfirmedCount();
		//治愈人数
		int curedNum = testInfoDao.selectCuredCount();
		//死亡人数
		int deadNum = testInfoDao.selectDeadCount();
		
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
	public List<TestInfo> selectForeignPName() {
		return testInfoDao.selectForeignPName();
	}

	@Override
	public List<HashMap<String, Object>> selectForeignYiqingByPName(String name) {
		TestInfo testinfo = testInfoDao.selectForeignYiqingByPName(name);
		//创建一个集合对象
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		
		//构建现有确诊的数据格式
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "现有确诊");
		map.put("value", testinfo.getCurrentConfirmedCount());
		list.add(map);
		
		//构建治愈人数的数据格式
		HashMap<String, Object> mapCure = new HashMap<String, Object>();
		mapCure.put("name", "现有治愈");
		mapCure.put("value", testinfo.getCuredCount());
		list.add(mapCure);
		
		//构建死亡人数的数据格式
		HashMap<String, Object> mapDead = new HashMap<String, Object>();
		mapDead.put("name", "现有死亡");
		mapDead.put("value", testinfo.getDeadCount());
		list.add(mapDead);
		return list;
	}

	@Override
	public HashMap<String, Object> selectForeignFiveConfrim() {
		List<TestInfo> list = testInfoDao.selectForeignFiveConfrim();
		//创建一个map对象
		HashMap<String, Object> map = new HashMap<String, Object>();
		//构建柱状图需要的数据格式
		if (null != list&& list.size()>0){
			//构建前五的国家名称
			List<String> listProvinceName = new ArrayList<>();
			//构建前五的确诊数据
			List<Integer> listData = new ArrayList<>();
			for(TestInfo testinfo:list){
				listProvinceName.add(testinfo.getProvinceName());
				listData.add(testinfo.getCurrentConfirmedCount());
			}
			map.put("area", listProvinceName);
			map.put("data",listData);
			//构建时间
			map.put("time", list.get(0).getTime());
		}
		return map;
	}

	@Override
	public HashMap<String, Object> selectForeignFiveCured() {
		List<TestInfo> list = testInfoDao.selectForeignFiveCured();
		//创建一个map对象
		HashMap<String, Object> map = new HashMap<String, Object>();
		//构建柱状图需要的数据格式
		if (null != list&& list.size()>0){
			//构建前五的国家名称
			List<String> listProvinceName = new ArrayList<>();
			//构建前五的确诊数据
			List<Integer> listData = new ArrayList<>();
			for(TestInfo testinfo:list){
				listProvinceName.add(testinfo.getProvinceName());
				listData.add(testinfo.getCuredCount());
			}
			map.put("area", listProvinceName);
			map.put("data",listData);
			//构建时间
			map.put("time", list.get(0).getTime());
		}
		return map;
	}

	@Override
	public HashMap<String, Object> selectForeignFiveDead() {
		List<TestInfo> list = testInfoDao.selectForeignFiveDead();
		//创建一个map对象
		HashMap<String, Object> map = new HashMap<String, Object>();
		//构建柱状图需要的数据格式
		if (null != list&& list.size()>0){
			//构建前五的国家名称
			List<String> listProvinceName = new ArrayList<>();
			//构建前五的确诊数据
			List<Integer> listData = new ArrayList<>();
			for(TestInfo testinfo:list){
				listProvinceName.add(testinfo.getProvinceName());
				listData.add(testinfo.getDeadCount());
			}
			map.put("area", listProvinceName);
			map.put("data",listData);
			//构建时间
			map.put("time", list.get(0).getTime());
		}
		return map;
	}

	@Override
	public List<HashMap<String, Object>> selectForeignYiqingInWeeks() {
		List<TestInfo> list =  testInfoDao.selectForeignYiqingInWeeks();
		
		//创建一个集合对象
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		//构建存储时间的数据格式
		List<String> listtime = new ArrayList<>();
		//构建现有确诊的数据格式
		List<Integer> listconfim = new ArrayList<>();
		//构建治愈人数的数据格式
		List<Integer> listcured = new ArrayList<>();
		//构建死亡人数的数据格式
		List<Integer> listdead = new ArrayList<>();
		for(TestInfo testinfo:list){
			System.out.println(testinfo.getTime());
			listtime.add(testinfo.getTime());
			//构建现有确诊的数据格式
			listconfim.add(testinfo.getCurrentConfirmedCount());
			
			listcured.add(testinfo.getCuredCount());
			
			listdead.add(testinfo.getDeadCount());
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "现有确诊");
		map.put("time", listtime);
		map.put("confimvalue", listconfim);
		listmap.add(map);
		
		//构建治愈人数的数据格式
		HashMap<String, Object> mapCure = new HashMap<String, Object>();
		mapCure.put("name", "现有治愈");
		mapCure.put("time", listtime);
		mapCure.put("curedvalue", listcured);
		listmap.add(mapCure);
		
		//构建死亡人数的数据格式
		HashMap<String, Object> mapDead = new HashMap<String, Object>();
		mapDead.put("name", "现有死亡");
		mapDead.put("time", listtime);
		mapDead.put("deadvalue", listdead);
		listmap.add(mapDead);
				
		return listmap;
	}

}
