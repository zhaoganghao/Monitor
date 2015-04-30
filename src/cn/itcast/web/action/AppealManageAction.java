package cn.itcast.web.action;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;

import cn.itcast.bean.Appeal;
import cn.itcast.bean.Rank;
import cn.itcast.bean.Source;
import cn.itcast.service.AppealService;
import cn.itcast.service.RankService;
import cn.itcast.service.SourceService;
import cn.itcast.utils.SiteUrl;
import cn.itcast.web.formbean.AppealForm;

@Controller("/control/appeal/manage")
public class AppealManageAction extends DispatchAction {
	@Resource(name="appealServiceImpl")
	private AppealService appealService;
	@Resource(name = "rankServiceImpl")
	private RankService rankService;
	@Resource(name = "sourceServiceImpl")
	private SourceService sourceService;
	
	public ActionForward queryUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {	
		request.setAttribute("ranks", rankService.getScrollData()
				.getResultlist());
		request.setAttribute("sources", sourceService.getScrollData()
				.getResultlist());
		return mapping.findForward("query");
	}
	public ActionForward editUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		AppealForm formbean = (AppealForm) form;
		Appeal appeal = appealService.find(formbean.getId());
		BeanUtils.copyProperties(appeal, formbean);
		if(appeal.getRank()!=null)
		formbean.setRankid(appeal.getRank().getId());
		if(appeal.getSource()!=null)
		formbean.setSourceid(appeal.getSource().getId());
		request.setAttribute("ranks", rankService.getScrollData()
				.getResultlist());
		request.setAttribute("sources", sourceService.getScrollData()
				.getResultlist());
		return mapping.findForward("edit");
	}
	
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		AppealForm formbean = (AppealForm) form;
		Appeal appeal=new Appeal();
		BeanUtils.copyProperties(formbean, appeal);
		
		if(formbean.getRankid()!=null&&formbean.getRankid()!=0){
			Rank rank=new Rank();
			rank.setId(formbean.getRankid());
			appeal.setRank(rank);
		}
		if(formbean.getSourceid()!=null&&formbean.getSourceid()!=0){
			Source source =new Source();
			source.setId(formbean.getSourceid());
			appeal.setSource(source);
		}
		appealService.update(appeal);
		request.setAttribute("message", "修改成功");
		request.setAttribute("urladdress", "/control/appeal/manage.do?method=editUI&id="+formbean.getId());
		return mapping.findForward("message");
	}
	
	public ActionForward addUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("ranks", rankService.getScrollData()
				.getResultlist());
		request.setAttribute("sources", sourceService.getScrollData()
				.getResultlist());
		return mapping.findForward("add");
	}
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		AppealForm formbean = (AppealForm) form;
		appealService.delete(formbean.getId());
		request.setAttribute("message", "删除成功");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.appeal.list"));
		return mapping.findForward("message");
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		AppealForm formbean = (AppealForm) form;
		Appeal appeal=new Appeal();
		BeanUtils.copyProperties(formbean, appeal);
		
		if(formbean.getRankid()!=null&&formbean.getRankid()!=0){
			Rank rank=new Rank();
			rank.setId(formbean.getRankid());
			appeal.setRank(rank);
		}
		if(formbean.getSourceid()!=null&&formbean.getSourceid()!=0){
			Source source =new Source();
			source.setId(formbean.getSourceid());
			appeal.setSource(source);
		}
		appealService.save(appeal);
		request.setAttribute("message", "添加成功");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.appeal.list"));
		return mapping.findForward("message");
	}
}
