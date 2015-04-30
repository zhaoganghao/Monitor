package cn.itcast.web.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;

import cn.itcast.service.HandlerWayService;
import cn.itcast.service.QuestionTypeService;
import cn.itcast.service.RankService;
import cn.itcast.service.RegisterService;
import cn.itcast.service.SourceService;
import cn.itcast.utils.SiteUrl;
import cn.itcast.web.formbean.ChartForm;
import cn.itcast.web.formbean.RegisterForm;

/**
 * 品牌管理
 * 
 */
@Controller("/control/chart/manage")
public class ChartManageAction extends DispatchAction {
	@Resource(name = "rankServiceImpl")
	private RankService rankService;

	@Resource(name = "sourceServiceImpl")
	private SourceService sourceService;

	@Resource(name = "questionTypeServiceImpl")
	private QuestionTypeService questionTypeService;

	@Resource(name = "registerServiceImpl")
	private RegisterService registerService;
	
	@Resource(name = "handlerWayServiceImpl")
	private HandlerWayService handlerWayService;
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
	RegisterForm formbean = (RegisterForm) form;
	registerService.delete(formbean.getId());
	request.setAttribute("message", "删除成功");
	request.setAttribute("urladdress", SiteUrl.readUrl("control.register.list"));
	return mapping.findForward("message");
	}

	public ActionForward queryUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("query");
	}
	public ActionForward dispatch(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ChartForm formbean=(ChartForm) form;
		String startdate=(String) request.getAttribute("startdate");
		Integer type=formbean.getType();
		if(type!=null&&type>0){
			request.setAttribute("ranks", rankService.getScrollData()
					.getResultlist());
			
			request.setAttribute("types", questionTypeService.getParentType());
			request.setAttribute("sources", sourceService.getScrollData()
					.getResultlist());
			if(type==1){
				return 	mapping.findForward("chart1");
			}else if(type==2){
				return 	mapping.findForward("chart2");
			}else{
				request.setAttribute("handlerways", handlerWayService.getParentType());
				return mapping.findForward("chart3");
			}
		}
		return mapping.findForward("query");
	}
	public ActionForward chart1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		
		return mapping.findForward("chart1");
	}
}
