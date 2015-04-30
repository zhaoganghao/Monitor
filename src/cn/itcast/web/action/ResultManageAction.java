package cn.itcast.web.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;

import cn.itcast.bean.QuestionType;
import cn.itcast.bean.Rank;
import cn.itcast.bean.Result;
import cn.itcast.bean.Source;
import cn.itcast.service.QuestionTypeService;
import cn.itcast.service.RankService;
import cn.itcast.service.ResultService;
import cn.itcast.service.SourceService;
import cn.itcast.utils.SiteUrl;
import cn.itcast.web.formbean.ResultForm;

/**
 * 品牌管理
 * 
 */
@Controller("/control/result/manage")
public class ResultManageAction extends DispatchAction {
	@Resource(name = "rankServiceImpl")
	private RankService rankService;

	@Resource(name = "sourceServiceImpl")
	private SourceService sourceService;

	@Resource(name = "questionTypeServiceImpl")
	private QuestionTypeService questionTypeService;

	@Resource(name = "resultServiceImpl")
	private ResultService resultService;

	public ActionForward queryUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("ranks", rankService.getScrollData()
				.getResultlist());
		request.setAttribute("types", questionTypeService.getParentType());
		request.setAttribute("sources", sourceService.getScrollData()
				.getResultlist());
		return mapping.findForward("query");
	}

	public ActionForward infor(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("query");
	}

	public ActionForward editUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ResultForm formbean = (ResultForm) form;
		Result result = resultService.find(formbean.getId());
		formbean.setId(result.getId());
		BeanUtils.copyProperties(result, formbean);
		if (result.getRank() != null)
			formbean.setRankid(result.getRank().getId());
		/*if (result.getSource() != null)
			formbean.setSourceid(result.getSource().getId());*/
		if (result.getMainbehavior() != null)
			formbean.setMainbehaviorid(result.getMainbehavior().getId());
		if (result.getNextbehavior() != null)
			formbean.setNextbehaviorid(result.getNextbehavior().getId());

		request.setAttribute("ranks", rankService.getScrollData()
				.getResultlist());
		request.setAttribute("types", questionTypeService.getParentType());
		request.setAttribute("sources", sourceService.getScrollData()
				.getResultlist());

		return mapping.findForward("edit");
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ResultForm formbean = (ResultForm) form;
		String filldateyear = formbean.getFilldateyear();
		String filldatemonth = formbean.getFilldatemonth();

		Result result = new Result();

		BeanUtils.copyProperties(formbean, result);
		Rank rank = new Rank();
		if (formbean.getRankid() != null && formbean.getRankid() != 0) {
			rank.setId(formbean.getRankid());
			result.setRank(rank);
		}

		QuestionType type = new QuestionType();
		if (formbean.getMainbehaviorid() != null
				&& formbean.getMainbehaviorid() != 0) {
			type.setId(formbean.getMainbehaviorid());
			result.setMainbehavior(type);
		}
		QuestionType type2 = new QuestionType();
		if (formbean.getNextbehaviorid() != null
				&& formbean.getNextbehaviorid() != 0) {
			type2.setId(formbean.getNextbehaviorid());
			result.setNextbehavior(type2);
		}

		/*Source source = new Source();
		if (formbean.getSourceid() != null && formbean.getSourceid() != 0) {
			source.setId(formbean.getSourceid());
			result.setSource(source);
		}*/

		resultService.update(result);
		request.setAttribute("message", "修改成功");
		request.setAttribute("urladdress",
				"control/result/manage.do?method=editUI&id="+formbean.getId());
		return mapping.findForward("message");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ResultForm formbean = (ResultForm) form;
		resultService.delete(formbean.getId());
		request.setAttribute("message", "删除成功");
		request.setAttribute("urladdress",
				SiteUrl.readUrl("control.result.list"));
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
		request.setAttribute("sources", sourceService.getScrollData()
				.getResultlist());
		return mapping.findForward("add");
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ResultForm formbean = (ResultForm) form;
		String filldateyear = formbean.getFilldateyear();
		String filldatemonth = formbean.getFilldatemonth();

		Result result = new Result();

		BeanUtils.copyProperties(formbean, result);
		Rank rank = new Rank();
		if (formbean.getRankid() != null && formbean.getRankid() != 0) {
			rank.setId(formbean.getRankid());
			result.setRank(rank);
		}

		QuestionType type = new QuestionType();
		if (formbean.getMainbehaviorid() != null
				&& formbean.getMainbehaviorid() != 0) {
			type.setId(formbean.getMainbehaviorid());
			result.setMainbehavior(type);
		}
		QuestionType type2 = new QuestionType();
		if (formbean.getNextbehaviorid() != null
				&& formbean.getNextbehaviorid() != 0) {
			type2.setId(formbean.getNextbehaviorid());
			result.setNextbehavior(type2);
		}

		/*Source source = new Source();
		if (formbean.getSourceid() != null && formbean.getSourceid() != 0) {
			source.setId(formbean.getSourceid());
			result.setSource(source);
		}*/

		resultService.save(result);
		request.setAttribute("message", "登记成功");
		request.setAttribute("urladdress",
				SiteUrl.readUrl("control.result.list"));
		return mapping.findForward("message");
	}
}
