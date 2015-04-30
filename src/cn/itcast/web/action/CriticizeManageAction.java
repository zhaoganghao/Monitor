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

import cn.itcast.bean.Criticize;
import cn.itcast.bean.Rank;
import cn.itcast.bean.Source;
import cn.itcast.service.CriticizeService;
import cn.itcast.service.RankService;
import cn.itcast.service.SourceService;
import cn.itcast.utils.SiteUrl;
import cn.itcast.web.formbean.CriticizeForm;

@Controller("/control/criticize/manage")
public class CriticizeManageAction extends DispatchAction {
	@Resource(name="criticizeServiceImpl")
	private CriticizeService criticizeService;
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
		CriticizeForm formbean = (CriticizeForm) form;
		Criticize criticize = criticizeService.find(formbean.getId());
		BeanUtils.copyProperties(criticize, formbean);
		if(criticize.getSource()!=null)
		formbean.setSourceid(criticize.getSource().getId());
		request.setAttribute("ranks", rankService.getScrollData()
				.getResultlist());
		request.setAttribute("sources", sourceService.getScrollData()
				.getResultlist());
		return mapping.findForward("edit");
	}
	
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		CriticizeForm formbean = (CriticizeForm) form;
		Criticize criticize=new Criticize();
		BeanUtils.copyProperties(formbean, criticize);
		
		if(formbean.getSourceid()!=null&&formbean.getSourceid()!=0){
			Source source =new Source();
			source.setId(formbean.getSourceid());
			criticize.setSource(source);
		}
		criticizeService.update(criticize);
		request.setAttribute("message", "修改成功");
		request.setAttribute("urladdress", "/control/criticize/manage.do?method=editUI&id="+formbean.getId());
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
		CriticizeForm formbean = (CriticizeForm) form;
		criticizeService.delete(formbean.getId());
		request.setAttribute("message", "删除成功");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.criticize.list"));
		return mapping.findForward("message");
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		CriticizeForm formbean = (CriticizeForm) form;
		Criticize criticize=new Criticize();
		BeanUtils.copyProperties(formbean, criticize);
		
		if(formbean.getSourceid()!=null&&formbean.getSourceid()!=0){
			Source source =new Source();
			source.setId(formbean.getSourceid());
			criticize.setSource(source);
		}
		criticizeService.save(criticize);
		request.setAttribute("message", "添加成功");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.criticize.list"));
		return mapping.findForward("message");
	}
}
