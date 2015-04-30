package cn.itcast.web.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;

import cn.itcast.base.bean.PageView;
import cn.itcast.bean.HandlerWay;
import cn.itcast.bean.QuestionType;
import cn.itcast.bean.Rank;
import cn.itcast.bean.Register;
import cn.itcast.bean.Relation;
import cn.itcast.bean.Source;
import cn.itcast.service.HandlerWayService;
import cn.itcast.service.QuestionTypeService;
import cn.itcast.service.RankService;
import cn.itcast.service.RegisterService;
import cn.itcast.service.RelationService;
import cn.itcast.service.SourceService;
import cn.itcast.utils.SiteUrl;
import cn.itcast.web.formbean.RegisterForm;

/**
 * 品牌管理
 * 
 */
@Controller("/control/register/manage")
public class RegisterManageAction extends DispatchAction {
	@Resource(name = "rankServiceImpl")
	private RankService rankService;

	@Resource(name = "sourceServiceImpl")
	private SourceService sourceService;

	@Resource(name = "questionTypeServiceImpl")
	private QuestionTypeService questionTypeService;

	@Resource(name = "registerServiceImpl")
	private RegisterService registerService;
	@Resource (name = "handlerWayServiceImpl")
	private HandlerWayService handlerWayService;
	@Resource (name = "relationServiceImpl")
	private RelationService relationService;
	/**
	 * 品牌查询界面
	 */
	public ActionForward queryUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("ranks", rankService.getScrollData()
				.getResultlist());
		request.setAttribute("types", questionTypeService.getParentType());
		request.setAttribute("sources", sourceService.getScrollData()
				.getResultlist());
		request.setAttribute("handlerways", handlerWayService.getParentType());
		return mapping.findForward("query");
	}
	public ActionForward queryHandlerWay(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		request.setAttribute("ranks", rankService.getScrollData()
				.getResultlist());
		request.setAttribute("types", questionTypeService.getParentType());
		request.setAttribute("sources", sourceService.getScrollData()
				.getResultlist());
		request.setAttribute("handlerways", handlerWayService.getParentType());
		return mapping.findForward("queryhandlerway");
	}
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		RegisterForm formbean = (RegisterForm) form;
		StringBuffer jpql = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		if ("true".equals(formbean.getQuery())) {
			if (formbean.getTypeid() != null && formbean.getTypeid() > 0) {
				List<Integer> typeids = new ArrayList<Integer>();
				typeids.add(formbean.getTypeid());
				List<Integer> subTypeid=questionTypeService.getSubTypeid(new Integer[]{formbean.getTypeid()});
				typeids.addAll(subTypeid);
				StringBuffer n = new StringBuffer();
				for(int i=0; i<typeids.size();i++){
					n.append('?').append((i+1)).append(',');
				}
				n.deleteCharAt(n.length()-1);
				jpql.append("  o.register.type.id in("+ n.toString()+ ")");
				params.addAll(typeids);
				
			}
			if (formbean.getHandlerway1id() != null && formbean.getHandlerway1id()> 0) {
				
				List<Integer> handlerwayids = new ArrayList<Integer>();
				handlerwayids.add(formbean.getHandlerway1id());
				List<Integer> subid=handlerWayService.getSubTypeid(new Integer[]{formbean.getHandlerway1id()});
				handlerwayids.addAll(subid);
				StringBuffer n = new StringBuffer();
				int j=params.size();
				for(int i=0; i<handlerwayids.size();i++){
					n.append('?').append((j+i+1)).append(',');
				}
				n.deleteCharAt(n.length()-1);
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append("  o.handlerway.id in("+ n.toString()+ ")");
				params.addAll(handlerwayids);
				
			}
			
			if (formbean.getReportedname()!= null
					&& !"".equals(formbean.getReportedname().trim())) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append(" o.register.reportedname like ?" + (params.size() + 1));
				params.add("%" + formbean.getReportedname() + "%");
			}
			if (formbean.getIndexcode() != null
					&& !"".equals(formbean.getIndexcode().trim())) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append(" o.register.indexcode like ?" + (params.size() + 1));
				params.add("%" + formbean.getIndexcode() + "%");
			}
			if (formbean.getSourcetwo() != null
					&& !"".equals(formbean.getSourcetwo().trim())) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append(" o.register.sourcetwo like ?" + (params.size() + 1));
				params.add("%" + formbean.getSourcetwo() + "%");
			}
			if (formbean.getHandlernumber() != null
					&& !"".equals(formbean.getHandlernumber().trim())) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append(" o.register.handlernumber like ?" + (params.size() + 1));
				params.add("%" + formbean.getHandlernumber()+ "%");
			}
			if (formbean.getSourcenumber()!= null
					&& !"".equals(formbean.getSourcenumber().trim())) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append(" o.register.sourcenumber like ?" + (params.size() + 1));
				params.add("%" + formbean.getSourcenumber()+ "%");
			}
			if (formbean.getPersoncode() != null
					&& !"".equals(formbean.getPersoncode().trim())) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append("  o.register.personcode like ?" + (params.size() + 1));

				params.add("%" + formbean.getPersoncode() + "%");
			}
			if (formbean.getMainthread() != null
					&& !"".equals(formbean.getMainthread().trim())) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append("  o.register.mainthread like ?" + (params.size() + 1));
				
				params.add("%" + formbean.getMainthread() + "%");
			}
			
			if (formbean.getSourceid() != null && formbean.getSourceid() > 0) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append("   o.register.source.id=?" + (params.size() + 1));
				params.add(formbean.getSourceid());
			}
			if (formbean.getStartdate() != null
					&& formbean.getEnddate() != null) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append(" o.register.filldate >=?" + (params.size() + 1));
				params.add(formbean.getStartdate());
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append("  o.register.filldate  <= ?" + (params.size() + 1));

				params.add(formbean.getEnddate());
			}
			if (formbean.getRankid() != null && formbean.getRankid() > 0) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append(" o.register.rank.id=?" + (params.size() + 1));
				params.add(formbean.getRankid());
			}

			if (formbean.getIspunish() != null && formbean.getIspunish() >= 0) {
				if (formbean.getIspunish() == 0) {
					if (params.size() > 0) {
						jpql.append(" and");
					}
					jpql.append("  o.register.size = 0");
				} else if (formbean.getIspunish() == 1) {
					if (params.size() > 0) {
						jpql.append(" and");
					}
					jpql.append("  o.register.size= 1");
				} else if (formbean.getIspunish() == 2) {
					if (params.size() > 0) {
						jpql.append(" and");
					}
					jpql.append("  o.register.size = 2");
				} else if (formbean.getIspunish() == 3) {
					if (params.size() > 0) {
						jpql.append(" and");
					}
					jpql.append("  o.register.size = 3");
				}
			}

		}
		PageView<Relation> pageView = new PageView<Relation>(12,
				formbean.getPage());
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("register.filldate", "desc");
		pageView.setQueryResult(relationService.getScrollData(
				pageView.getFirstResult(), pageView.getMaxresult(),
				jpql.toString(), params.toArray(), orderby));
		request.setAttribute("pageView", pageView);
		return mapping.findForward("listhandlerway");
	}
	
	public ActionForward unhandler(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		RegisterForm formbean = (RegisterForm) form;
		StringBuffer jpql = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		
		jpql.append("  o.size= 0 or o.size= 1 or o.size= 2");
		PageView<Register> pageView = new PageView<Register>(12,
				formbean.getPage());
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("filldate", "desc");
		pageView.setQueryResult(registerService.getScrollData(
				pageView.getFirstResult(), pageView.getMaxresult(),
				jpql.toString(), params.toArray(), orderby));
		request.setAttribute("pageView", pageView);
		return mapping.findForward("list");
	}
	public ActionForward handlered(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		RegisterForm formbean = (RegisterForm) form;
		StringBuffer jpql = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		
		jpql.append("  o.size= 3 ");
		PageView<Register> pageView = new PageView<Register>(12,
				formbean.getPage());
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("filldate", "desc");
		pageView.setQueryResult(registerService.getScrollData(
				pageView.getFirstResult(), pageView.getMaxresult(),
				jpql.toString(), params.toArray(), orderby));
		request.setAttribute("pageView", pageView);
		return mapping.findForward("list");
	}
	public ActionForward print(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		RegisterForm formbean = (RegisterForm) form;
		Register register = registerService.find(formbean.getId());
		BeanUtils.copyProperties(register, formbean);
		
		Set<Relation> relations=register.getRelations();
		List<Relation> list = new ArrayList<Relation>(relations);
		Collections.sort(list);
		
		Iterator<Relation> iterator=list.iterator();
		if(relations.size()==1){
			Relation relation1=iterator.next();
			formbean.setHandlerdate1(relation1.getCreatedate());
			formbean.setHandlerway1id(relation1.getHandlerway().getId());
			formbean.setHandlerway1(relation1.getHandlerway().getName());
			
		}else if(relations.size()==2){
			Relation relation1=iterator.next();
			Relation relation2=iterator.next();
			formbean.setHandlerdate1(relation1.getCreatedate());
			formbean.setHandlerdate2(relation2.getCreatedate());
			formbean.setHandlerway1id(relation1.getHandlerway().getId());
			formbean.setHandlerway2id(relation2.getHandlerway().getId());
			formbean.setHandlerway1(relation1.getHandlerway().getName());
			formbean.setHandlerway2(relation2.getHandlerway().getName());
		}else if(relations.size()==3){
			Relation relation1=iterator.next();
			Relation relation2=iterator.next();
			Relation relation3=iterator.next();
			formbean.setHandlerdate1(relation1.getCreatedate());
			formbean.setHandlerdate2(relation2.getCreatedate());
			formbean.setHandlerdate3(relation3.getCreatedate());
			formbean.setHandlerway1id(relation1.getHandlerway().getId());
			formbean.setHandlerway2id(relation2.getHandlerway().getId());
			formbean.setHandlerway3id(relation3.getHandlerway().getId());
			formbean.setHandlerway1(relation1.getHandlerway().getName());
			formbean.setHandlerway2(relation2.getHandlerway().getName());
			formbean.setHandlerway3(relation3.getHandlerway().getName());
		}
		request.setAttribute("handlerways", handlerWayService.getParentType());
		request.setAttribute("register", register);
		return mapping.findForward("print");
	}
	public ActionForward editUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		RegisterForm formbean = (RegisterForm) form;
		Register register = registerService.find(formbean.getId());
		/*if(register.getFilldate()!=null){
			DateFormat format=new SimpleDateFormat("yyyy");
			String year=format.format(register.getFilldate());
			formbean.setFilldateyear(year);
			DateFormat format2=new SimpleDateFormat("MM");
			String month=format2.format(register.getFilldate());
			formbean.setFilldatemonth(month);
		}*/
		BeanUtils.copyProperties(register, formbean);
		if(register.getRank()!=null)
		formbean.setRankid(register.getRank().getId());
		if(register.getSource()!=null)
		formbean.setSourceid(register.getSource().getId());
		if(register.getType()!=null)
		formbean.setTypeid(register.getType().getId());
		Set<Relation> relations=register.getRelations();
		List<Relation> list = new ArrayList<Relation>(relations);
		Collections.sort(list);
		
		Iterator<Relation> iterator=list.iterator();
		if(relations.size()==1){
			Relation relation1=iterator.next();
			formbean.setHandlerdate1(relation1.getCreatedate());
			formbean.setHandlerway1id(relation1.getHandlerway().getId());
			formbean.setRelationid1(relation1.getId());
			
		}else if(relations.size()==2){
			Relation relation1=iterator.next();
			Relation relation2=iterator.next();
			formbean.setHandlerdate1(relation1.getCreatedate());
			formbean.setHandlerdate2(relation2.getCreatedate());
			formbean.setHandlerway1id(relation1.getHandlerway().getId());
			formbean.setHandlerway2id(relation2.getHandlerway().getId());
			formbean.setRelationid1(relation1.getId());
			formbean.setRelationid2(relation2.getId());
		}else if(relations.size()==3){
			Relation relation1=iterator.next();
			Relation relation2=iterator.next();
			Relation relation3=iterator.next();
			formbean.setHandlerdate1(relation1.getCreatedate());
			formbean.setHandlerdate2(relation2.getCreatedate());
			formbean.setHandlerdate3(relation3.getCreatedate());
			formbean.setHandlerway1id(relation1.getHandlerway().getId());
			formbean.setHandlerway2id(relation2.getHandlerway().getId());
			formbean.setHandlerway3id(relation3.getHandlerway().getId());
			formbean.setRelationid1(relation1.getId());
			formbean.setRelationid2(relation2.getId());
			formbean.setRelationid3(relation3.getId());
		}
		
		
		request.setAttribute("ranks", rankService.getScrollData()
				.getResultlist());
		request.setAttribute("types", questionTypeService.getParentType());
		request.setAttribute("sources", sourceService.getScrollData()
				.getResultlist());
		request.setAttribute("handlerways", handlerWayService.getParentType());
		return mapping.findForward("edit");
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		RegisterForm formbean = (RegisterForm) form;
		String filldateyear=formbean.getFilldateyear();
		String filldatemonth=formbean.getFilldatemonth();
		/*Date filldate=null;
		if(filldateyear!=null&&!"".equals(filldateyear.trim())&&filldatemonth!=null&&!"".equals(filldatemonth.trim())){
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			filldate=format.parse(filldateyear+"-"+filldatemonth+"-"+"1");
		}*/
		Register register = new Register();
		BeanUtils.copyProperties(formbean, register);
		//register.setFilldate(filldate);
		if(formbean.getRankid()!=null&&formbean.getRankid()!=0){
			Rank rank=new Rank();
			rank.setId(formbean.getRankid());
			register.setRank(rank);
		}
		
		
		if(formbean.getTypeid()!=null&&formbean.getTypeid()!=0){
			QuestionType type =new QuestionType();
			type.setId(formbean.getTypeid());
			register.setType(type);
		}
		
		if(formbean.getSourceid()!=null&&formbean.getSourceid()!=0){
			Source source =new Source();
			source.setId(formbean.getSourceid());
			register.setSource(source);
		}
		registerService.update(register);
		
		if(formbean.getHandlerdate1()!=null&&formbean.getHandlerway1id()!=null&&formbean.getHandlerway1id()!=0){
			Relation relation = new Relation();
			relation.setCreatedate(formbean.getHandlerdate1());
			relation.setHandlerway(new HandlerWay(formbean.getHandlerway1id()));
			relation.setRegister(register);
			if(formbean.getRelationid1()!=null&&formbean.getRelationid1()!=0){
				relation.setId(formbean.getRelationid1());
				relationService.update(relation);
			}else{
				relationService.save(relation);
			}
			register.getRelations().add(relation);
		}else{
			Relation relation = new Relation();
			if(formbean.getRelationid1()!=null&&formbean.getRelationid1()!=0){
				relationService.delete(formbean.getRelationid1());
			}
		}
		if(formbean.getHandlerdate2()!=null&&formbean.getHandlerway2id()!=null&&formbean.getHandlerway2id()!=0){
			Relation relation = new Relation();
			relation.setCreatedate(formbean.getHandlerdate2());
			relation.setHandlerway(new HandlerWay(formbean.getHandlerway2id()));
			relation.setRegister(register);
			if(formbean.getRelationid2()!=null&&formbean.getRelationid2()!=0){
				relation.setId(formbean.getRelationid2());
				relationService.update(relation);
			}else{
				relationService.save(relation);
			}
			register.getRelations().add(relation);
		}else{
			Relation relation = new Relation();
			if(formbean.getRelationid2()!=null&&formbean.getRelationid2()!=0){
				relationService.delete(formbean.getRelationid2());
			}
		}
		
		if(formbean.getHandlerdate3()!=null&&formbean.getHandlerway3id()!=null&&formbean.getHandlerway3id()!=0){
			Relation relation = new Relation();
			relation.setCreatedate(formbean.getHandlerdate3());
			relation.setHandlerway(new HandlerWay(formbean.getHandlerway3id()));
			relation.setRegister(register);
			if(formbean.getRelationid3()!=null&&formbean.getRelationid3()!=0){
				relation.setId(formbean.getRelationid3());
				relationService.update(relation);
			}else{
				relationService.save(relation);
			}
			register.getRelations().add(relation);
		}else{
			Relation relation = new Relation();
			if(formbean.getRelationid3()!=null&&formbean.getRelationid3()!=0){
				relationService.delete(formbean.getRelationid3());
			}
		}
		register.setSize(register.getRelations().size());
		registerService.update(register);
		request.setAttribute("message", "修改成功");
		request.setAttribute("urladdress","/control/register/manage.do?method=editUI&id="+formbean.getId());
		return mapping.findForward("message");
	}
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
	RegisterForm formbean = (RegisterForm) form;
	registerService.delete(formbean.getId());
	request.setAttribute("message", "删除成功");
	request.setAttribute("urladdress", SiteUrl.readUrl("control.register.list"));
	return mapping.findForward("message");
	}

	/**
	 * 品牌添加界面
	 */
	public ActionForward addUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("ranks", rankService.getScrollData()
				.getResultlist());
		
		request.setAttribute("types", questionTypeService.getParentType());
		request.setAttribute("handlerways", handlerWayService.getParentType());
		request.setAttribute("sources", sourceService.getScrollData()
				.getResultlist());
		return mapping.findForward("add");
	}
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		RegisterForm formbean = (RegisterForm) form;
		String filldateyear=formbean.getFilldateyear();
		String filldatemonth=formbean.getFilldatemonth();
		/*Date filldate=null;
		if(filldateyear!=null&&!"".equals(filldateyear.trim())&&filldatemonth!=null&&!"".equals(filldatemonth.trim())){
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			filldate=format.parse(filldateyear+"-"+filldatemonth+"-"+"1");
		}*/
		Register register = new Register();
		BeanUtils.copyProperties(formbean, register);
		//register.setFilldate(filldate);
		Rank rank=new Rank();
		if(formbean.getRankid()!=null&&formbean.getRankid()!=0){
			rank.setId(formbean.getRankid());
			register.setRank(rank);
		}
		QuestionType type =new QuestionType();
		if(formbean.getTypeid()!=null&&formbean.getTypeid()!=0){
			type.setId(formbean.getTypeid());
			register.setType(type);
		}
		Source source =new Source();
		if(formbean.getSourceid()!=null&&formbean.getSourceid()!=0){
			source.setId(formbean.getSourceid());
			register.setSource(source);
		}
		registerService.save(register);
		if(formbean.getHandlerdate1()!=null&&formbean.getHandlerway1id()!=null&&formbean.getHandlerway1id()!=0){
			Relation relation = new Relation();
			relation.setCreatedate(formbean.getHandlerdate1());
			relation.setHandlerway(new HandlerWay(formbean.getHandlerway1id()));
			relation.setRegister(register);
			relationService.save(relation);
			register.getRelations().add(relation);
		}
		if(formbean.getHandlerdate2()!=null&&formbean.getHandlerway2id()!=null&&formbean.getHandlerway2id()!=0){
			Relation relation = new Relation();
			relation.setCreatedate(formbean.getHandlerdate2());
			relation.setHandlerway(new HandlerWay(formbean.getHandlerway2id()));
			relation.setRegister(register);
			relationService.save(relation);
			register.getRelations().add(relation);
		}
		if(formbean.getHandlerdate3()!=null&&formbean.getHandlerway3id()!=null&&formbean.getHandlerway3id()!=0){
			Relation relation = new Relation();
			relation.setCreatedate(formbean.getHandlerdate3());
			relation.setHandlerway(new HandlerWay(formbean.getHandlerway3id()));
			relation.setRegister(register);
			relationService.save(relation);
			register.getRelations().add(relation);
		}
		register.setSize(register.getRelations().size());
		registerService.update(register);
		
		request.setAttribute("message", "登记成功");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.register.list"));
		return mapping.findForward("message");
	}
}
