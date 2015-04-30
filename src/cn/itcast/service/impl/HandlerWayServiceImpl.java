package cn.itcast.service.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bean.HandlerWay;
import cn.itcast.bean.QuestionType;
import cn.itcast.service.HandlerWayService;
import cn.itcast.service.base.DaoSupport;
@Service
@Transactional
public class HandlerWayServiceImpl extends DaoSupport<HandlerWay> implements HandlerWayService{
	@Override
	public List<HandlerWay> getParentType() {
		List<HandlerWay> types=this.em.createQuery("select o from HandlerWay o where o.parent is empty").getResultList();
		return types;
	}
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public List<Integer> getSubTypeid(Integer[] parentids){
		if(parentids!=null && parentids.length>0){
			StringBuffer jpql = new StringBuffer();
			for(int i=0; i<parentids.length; i++){
				jpql.append('?').append((i+1)).append(',');
			}
			jpql.deleteCharAt(jpql.length()-1);
			Query query = em.createQuery("select o.id from HandlerWay o where o.parent.id in("+ jpql.toString()+ ")");
			for(int i=0; i<parentids.length; i++){
				query.setParameter(i+1, parentids[i]);
			}
			return query.getResultList();
		}
		return null;
	}
}
