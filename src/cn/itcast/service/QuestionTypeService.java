package cn.itcast.service;

import java.util.List;

import cn.itcast.bean.QuestionType;
import cn.itcast.service.base.DAO;

public interface QuestionTypeService extends  DAO<QuestionType>{
	public  List<QuestionType> getParentType();
	
	public List<Integer> getSubTypeid(Integer[] parentids);
}
