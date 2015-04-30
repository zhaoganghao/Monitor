package cn.itcast.elfunction;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ChartFunction {
	static EntityManager em;
	static {
		ApplicationContext c=new ClassPathXmlApplicationContext("beans.xml");
		EntityManagerFactory factory= (EntityManagerFactory) c.getBean("entityManagerFactory");
		em = factory.createEntityManager();
	}
	
	 public static Integer sourceAndType(Integer sourceid,Integer typeid,Date startdate,Date enddate) {
		 
		 Query query1 = em.createQuery("select o.id from QuestionType o where o.parent.id ="+ typeid);
		 List<Integer> ids=query1.getResultList();
		 ids.add(typeid);
			StringBuffer n = new StringBuffer();
			for(int i=0; i<ids.size();i++){
				n.append('?').append((i+1)).append(',');
			}
			n.deleteCharAt(n.length()-1);
         Query query2 = em.createQuery("select count(o) from Register o where " +
         		"o.type.id in("+n.toString()+") and o.source.id =?"+(ids.size()+1)+" and o.filldate >=?"+(ids.size()+2)+" and o.filldate <=?"+(ids.size()+3))	;
		if(ids!=null && ids.size()>0){
			for(int i=0; i<ids.size(); i++){
				query2.setParameter(i+1, ids.get(i));
			}
		}
		query2.setParameter(ids.size()+1, sourceid);
		query2.setParameter(ids.size()+2, startdate);
		query2.setParameter(ids.size()+3, enddate);
		
		long count=(Long) query2.getSingleResult();
         return (int)count;
	 }
	 public static Integer source(Integer sourceid,Date startdate,Date enddate) {
			long count= (Long) em.createQuery("select count(o) from Register o where o.source.id =? and o.filldate >=? and o.filldate <=? ")
					.setParameter(1, sourceid ).setParameter(2,startdate ).setParameter(3, enddate).getSingleResult();
			 return (int)count;
		 }
	 public static Integer type(Integer typeid,Date startdate,Date enddate) {
		 Query query1 = em.createQuery("select o.id from QuestionType o where o.parent.id ="+ typeid);
		 List<Integer> ids=query1.getResultList();
		 ids.add(typeid);
			StringBuffer n = new StringBuffer();
			for(int i=0; i<ids.size();i++){
				n.append('?').append((i+1)).append(',');
			}
			n.deleteCharAt(n.length()-1);
		 Query query2= em.createQuery("select count(o) from Register o where o.type.id in("+n.toString()+") " +
		 		"and o.filldate >=?"+(ids.size()+1)+" and o.filldate <=?"+(ids.size()+2));
		 if(ids!=null && ids.size()>0){
				for(int i=0; i<ids.size(); i++){
					query2.setParameter(i+1, ids.get(i));
				}
			}
			query2.setParameter(ids.size()+1, startdate);
			query2.setParameter(ids.size()+2, enddate);
			
			long count=(Long) query2.getSingleResult();
	         return (int)count;
	 }
	 public static Integer rankAndType(Integer rankid,Integer typeid,Date startdate,Date enddate) {
		 Query query1 = em.createQuery("select o.id from QuestionType o where o.parent.id ="+ typeid);
		 List<Integer> ids=query1.getResultList();
		 ids.add(typeid);
			StringBuffer n = new StringBuffer();
			for(int i=0; i<ids.size();i++){
				n.append('?').append((i+1)).append(',');
			}
			n.deleteCharAt(n.length()-1);
         Query query2 = em.createQuery("select count(o) from Register o where " +
         		"o.type.id in("+n.toString()+") and o.rank.id =?"+(ids.size()+1)+" and o.filldate >=?"+(ids.size()+2)+" and o.filldate <=?"+(ids.size()+3))	;
		if(ids!=null && ids.size()>0){
			for(int i=0; i<ids.size(); i++){
				query2.setParameter(i+1, ids.get(i));
			}
		}
		query2.setParameter(ids.size()+1, rankid);
		query2.setParameter(ids.size()+2, startdate);
		query2.setParameter(ids.size()+3, enddate);
		
		long count=(Long) query2.getSingleResult();
         return (int)count;
		 
	 }
	 public static Integer rank(Integer rankid,Date startdate,Date enddate) {
		 long count= (Long) em.createQuery("select count(o) from Register o where o.rank.id=? and o.filldate >=? and o.filldate <=?")
				 .setParameter(1, rankid).setParameter(2,startdate ).setParameter(3, enddate).getSingleResult();
		 return (int)count;
	 }
	 public static Integer allType(Date startdate,Date enddate) {
		 
		 long count= (Long) em.createQuery("select count(o) from Register o where  o.filldate >=? and o.filldate <=?")
				 .setParameter(1,startdate ).setParameter(2, enddate).getSingleResult();
		 return (int)count;
	 }
	 
	 
	 public static Integer allAppeal(Date startdate,Date enddate) {
		 long count= (Long) em.createQuery("select count(o) from Appeal o where  o.filldate >=? and o.filldate <=?")
				 .setParameter(1,startdate ).setParameter(2, enddate).getSingleResult();
		 return (int)count;
	 }
	 public static Integer sourceAndAppeal(Integer sourceid,Date startdate,Date enddate) {
		 long count= (Long) em.createQuery("select count(o) from Appeal o where  o.source.id=? and o.filldate >=? and o.filldate <=?")
				 .setParameter(1, sourceid).setParameter(2,startdate ).setParameter(3, enddate).getSingleResult();
		 return (int)count;
	 }
	 public static Integer rankAndAppeal(Integer rankid,Date startdate,Date enddate) {
		 long count= (Long) em.createQuery("select count(o) from Appeal o where  o.rank.id=? and o.filldate >=? and o.filldate <=?")
				 .setParameter(1, rankid).setParameter(2,startdate ).setParameter(3, enddate).getSingleResult();
		 return (int)count;
	 }
	 
	 
	 
	 public static Integer allCriticize(Date startdate,Date enddate) {
		 long count= (Long) em.createQuery("select count(o) from Criticize o where  o.filldate >=? and o.filldate <=?")
				 .setParameter(1,startdate ).setParameter(2, enddate).getSingleResult();
		 return (int)count;
	 }
	 public static Integer sourceAndCriticize(Integer sourceid,Date startdate,Date enddate) {
		 long count= (Long) em.createQuery("select count(o) from Criticize o where  o.source.id=? and o.filldate >=? and o.filldate <=?")
				 .setParameter(1, sourceid).setParameter(2,startdate ).setParameter(3, enddate).getSingleResult();
		 return (int)count;
	 }
	 public static Integer rankAndCriticize(Integer rankid,Date startdate,Date enddate) {
		 long count= (Long) em.createQuery("select count(o) from Criticize o where  o.rank.id=? and o.filldate >=? and o.filldate <=?")
				 .setParameter(1, rankid).setParameter(2,startdate ).setParameter(3, enddate).getSingleResult();
		 return (int)count;
	 }
	 
	 
	 public static Integer allNoContent(Date startdate,Date enddate) {
		 long count= (Long) em.createQuery("select count(o) from NoContent o where  o.filldate >=? and o.filldate <=?")
				 .setParameter(1,startdate ).setParameter(2, enddate).getSingleResult();
		 return (int)count;
	 }
	 public static Integer sourceAndNoContent(Integer sourceid,Date startdate,Date enddate) {
		 long count= (Long) em.createQuery("select count(o) from NoContent o where  o.source.id=? and o.filldate >=? and o.filldate <=?")
				 .setParameter(1, sourceid).setParameter(2,startdate ).setParameter(3, enddate).getSingleResult();
		 return (int)count;
	 }
	 public static Integer rankAndNoContent(Integer rankid,Date startdate,Date enddate) {
		 long count= (Long) em.createQuery("select count(o) from NoContent o where  o.rank.id=? and o.filldate >=? and o.filldate <=?")
				 .setParameter(1, rankid).setParameter(2,startdate ).setParameter(3, enddate).getSingleResult();
		 return (int)count;
	 }
	 
	 
	 
	 public static Integer allOther(Date startdate,Date enddate) {
		 long count= (Long) em.createQuery("select count(o) from Other o where  o.filldate >=? and o.filldate <=?")
				 .setParameter(1,startdate ).setParameter(2, enddate).getSingleResult();
		 return (int)count;
	 }
	 public static Integer allOtherByEach(String type,Date startdate,Date enddate) {
		 long count= (Long) em.createQuery("select count(o) from Other o where  o.filldate >=? and o.filldate <=? and o.questiontype like ?")
				 .setParameter(1,startdate ).setParameter(2, enddate).setParameter(3, "%"+type+"%").getSingleResult();
		 return (int)count;
	 }
	 public static Integer sourceAndOther(String type,Integer sourceid,Date startdate,Date enddate) {
		 long count= (Long) em.createQuery("select count(o) from Other o where  o.source.id=? and o.filldate >=? and o.filldate <=? and o.questiontype like ?")
				 .setParameter(1, sourceid).setParameter(2,startdate ).setParameter(3, enddate).setParameter(4, "%"+type+"%").getSingleResult();
		 return (int)count;
	 }
	 public static Integer rankAndOther(String type,Integer rankid,Date startdate,Date enddate) {
		 long count= (Long) em.createQuery("select count(o) from Other o where  o.rank.id=? and o.filldate >=? and o.filldate <=? and o.questiontype like ?")
				 .setParameter(1, rankid).setParameter(2,startdate ).setParameter(3, enddate).setParameter(4, "%"+type+"%").getSingleResult();
		 return (int)count;
	 }
	 public static Integer rankAndOther(Integer rankid,Date startdate,Date enddate) {
		 long count= (Long) em.createQuery("select count(o) from Other o where  o.rank.id=? and o.filldate >=? and o.filldate <=? ")
				 .setParameter(1, rankid).setParameter(2,startdate ).setParameter(3, enddate).getSingleResult();
		 return (int)count;
	 }
	 public static Integer sourceAndOther(Integer sourceid,Date startdate,Date enddate) {
		 long count= (Long) em.createQuery("select count(o) from Other o where  o.source.id=? and o.filldate >=? and o.filldate <=? ")
				 .setParameter(1, sourceid).setParameter(2,startdate ).setParameter(3, enddate).getSingleResult();
		 return (int)count;
	 }
	 
	 public static Integer rankAndSource(Integer sourceid,Integer rankid,Date startdate,Date enddate) {
		 long count= (Long) em.createQuery("select count(o) from Register o where  o.source.id=? and o.rank.id=? and o.filldate >=? and o.filldate <=? ")
				 .setParameter(1, sourceid).setParameter(2, rankid).setParameter(3,startdate ).setParameter(4, enddate).getSingleResult();
		 return (int)count;
	 }
	 public static Integer rankAndHandlerWay(String  handlerway,Integer rankid,Date startdate,Date enddate) {
		 /*long count= (Long) em.createQuery("select count(o) from Relation o where  o.handlerway.name=? and o.register.rank.id=? and o.register.filldate >=? and o.register.filldate <=?  ")
				 .setParameter(1, handlerway).setParameter(2, rankid).setParameter(3,startdate ).setParameter(4, enddate).getSingleResult();
		 return (int)count;*/
		 Query query1 = em.createQuery("select o.id from HandlerWay o where o.parent.name like '%"+ handlerway+"%'");
		 Query query2 = em.createQuery("select o.id from HandlerWay o where o.name like '%"+ handlerway+"%'");
		 
		 List<Integer> ids=query1.getResultList();
		 List<Integer> ids2=query2.getResultList();
		 ids.add(ids2.get(0));		 
			StringBuffer n = new StringBuffer();
			for(int i=0; i<ids.size();i++){
				n.append('?').append((i+1)).append(',');
			}
			n.deleteCharAt(n.length()-1);
		 Query query3= em.createQuery("select count(o) from Relation o where o.handlerway.id in("+n.toString()+") " +" and o.register.rank.id= "+rankid+
		 		"and o.register.filldate >=?"+(ids.size()+1)+" and o.register.filldate <=?"+(ids.size()+2));
		 if(ids!=null && ids.size()>0){
				for(int i=0; i<ids.size(); i++){
					query3.setParameter(i+1, ids.get(i));
				}
			}
			query3.setParameter(ids.size()+1, startdate);
			query3.setParameter(ids.size()+2, enddate);
			
			long count=(Long) query3.getSingleResult();
	         return (int)count;
	 }
	 public static Integer handlerWay(String  handlerway,Date startdate,Date enddate) {
		 /*long count= (Long) em.createQuery("select count(o) from Relation o where  o.handlerway.name=? and o.register.filldate >=? and o.register.filldate <=?  ")
				 .setParameter(1, handlerway).setParameter(2,startdate ).setParameter(3, enddate).getSingleResult();
		 return (int)count;*/
		 Query query1 = em.createQuery("select o.id from HandlerWay o where o.parent.name like '%"+ handlerway+"%'");
		 Query query2 = em.createQuery("select o.id from HandlerWay o where o.name like '%"+ handlerway+"%'");
		 List<Integer> ids=query1.getResultList();
		 List<Integer> ids2=query2.getResultList();
		 ids.add(ids2.get(0));
		 StringBuffer n = new StringBuffer();
			for(int i=0; i<ids.size();i++){
				n.append('?').append((i+1)).append(',');
			}
			n.deleteCharAt(n.length()-1);
		 Query query3= em.createQuery("select count(o) from Relation o where o.handlerway.id in("+n.toString()+") " +
		 		"and o.register.filldate >=?"+(ids.size()+1)+" and o.register.filldate <=?"+(ids.size()+2));
		 if(ids!=null && ids.size()>0){
				for(int i=0; i<ids.size(); i++){
					query3.setParameter(i+1, ids.get(i));
				}
			}
			query3.setParameter(ids.size()+1, startdate);
			query3.setParameter(ids.size()+2, enddate);
			
			long count=(Long) query3.getSingleResult();
	         return (int)count;
	 }
 public static Integer allTypeHandlered(Date startdate,Date enddate) {
		 
		 long count= (Long) em.createQuery("select count(o) from Register o where  o.filldate >=? and o.filldate <=? and o.size > 0")
				 .setParameter(1,startdate ).setParameter(2, enddate).getSingleResult();
		 return (int)count;
	 }
 public static Integer sourceTwo(String name,Date startdate,Date enddate) {
	 
	 long count= (Long) em.createQuery("select count(o) from Register o where o.sourcetwo like '%"+name+"%' and o.filldate >=? and o.filldate <=? and o.size > 0")
			 .setParameter(1,startdate ).setParameter(2, enddate).getSingleResult();
	 return (int)count;
 }
 public static Integer sourceTwoAndRank(String name,Integer rankid,Date startdate,Date enddate) {
	 
	 long count= (Long) em.createQuery("select count(o) from Register o where o.sourcetwo like '%"+name+"%' and o.rank.id=? and o.filldate >=? and o.filldate <=? and o.size > 0")
			 .setParameter(1,rankid ).setParameter(2,startdate ).setParameter(3, enddate).getSingleResult();
	 return (int)count;
 }
 
}
