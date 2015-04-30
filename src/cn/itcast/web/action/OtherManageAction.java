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

import cn.itcast.bean.Other;
import cn.itcast.bean.Rank;
import cn.itcast.bean.Source;
import cn.itcast.service.OtherService;
import cn.itcast.service.RankService;
import cn.itcast.service.SourceService;
import cn.itcast.utils.SiteUrl;
import cn.itcast.web.formbean.OtherForm;

@Controller("/control/other/manage")
public class OtherManageAction extends DispatchAction {
	@Resource(name="otherServiceImpl")
	private OtherService otherService;
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
		OtherForm formbean = (OtherForm) form;
		Other other = otherService.find(formbean.getId());
		BeanUtils.copyProperties(other, formbean);
		if(other.getSource()!=null)
		formbean.setSourceid(other.getSource().getId());
		request.setAttribute("ranks", rankService.getScrollData()
				.getResultlist());
		request.setAttribute("sources", sourceService.getScrollData()
				.getResultlist());
		return mapping.findForward("edit");
	}
	
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		OtherForm formbean = (OtherForm) form;
		Other other=new Other();
		BeanUtils.copyProperties(formbean, other);
		
		if(formbean.getSourceid()!=null&&formbean.getSourceid()!=0){
			Source source =new Source();
			source.setId(formbean.getSourceid());
			other.setSource(source);
		}
		otherService.update(other);
		request.setAttribute("message", "修改成功");
		request.setAttribute("urladdress", "/control/other/manage.do?method=editUI&id="+formbean.getId());
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
		OtherForm formbean = (OtherForm) form;
		otherService.delete(formbean.getId());
		request.setAttribute("message", "删除成功");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.other.list"));
		return mapping.findForward("message");
	}
	
	/**
	 * 品牌添加
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		OtherForm formbean = (OtherForm) form;
		Other other=new Other();
		BeanUtils.copyProperties(formbean, other);
		
		if(formbean.getSourceid()!=null&&formbean.getSourceid()!=0){
			Source source =new Source();
			source.setId(formbean.getSourceid());
			other.setSource(source);
		}
		otherService.save(other);
		request.setAttribute("message", "添加成功");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.other.list"));
		return mapping.findForward("message");
	}
}
