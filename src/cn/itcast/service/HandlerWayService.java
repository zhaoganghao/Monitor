package cn.itcast.service;

import java.util.List;

import cn.itcast.bean.HandlerWay;
import cn.itcast.service.base.DAO;

public interface HandlerWayService extends  DAO<HandlerWay>{
	public  List<HandlerWay> getParentType();
	public List<Integer> getSubTypeid(Integer[] parentids);
}
