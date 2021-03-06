package cn.itcast.web.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import cn.itcast.base.bean.PageView;
import cn.itcast.bean.Other;
import cn.itcast.service.OtherService;
import cn.itcast.web.formbean.OtherForm;


@Controller("/control/other/list")
public class OtherAction extends Action {
	@Resource(name="otherServiceImpl")
	private OtherService otherService;

	@Override 
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		OtherForm formbean = (OtherForm) form;
		StringBuffer jpql = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		PageView<Other> pageView = new PageView<Other>(12, formbean.getPage());
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if ("true".equals(formbean.getQuery())) {
			if (formbean.getIndexcode() != null
					&& !"".equals(formbean.getIndexcode().trim())) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append(" o.indexcode like ?" + (params.size() + 1));
				params.add("%" + formbean.getIndexcode() + "%");
			}
			
			if (formbean.getReportedname()!= null
					&& !"".equals(formbean.getReportedname().trim())) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append(" o.reportedname like ?" + (params.size() + 1));
				params.add("%" + formbean.getReportedname() + "%");
			}
			if (formbean.getHandlerway()!= null
					&& !"".equals(formbean.getHandlerway().trim())) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append(" o.handlerway like ?" + (params.size() + 1));
				params.add("%" + formbean.getHandlerway() + "%");
			}
			if (formbean.getQuestiontype()!= null
					&& !"".equals(formbean.getQuestiontype().trim())) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append(" o.questiontype like ?" + (params.size() + 1));
				params.add("%" + formbean.getQuestiontype() + "%");
			}

			
			if (formbean.getSourceid() != null && formbean.getSourceid() > 0) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append("   o.source.id=?" + (params.size() + 1));
				params.add(formbean.getSourceid());
			}
			if (formbean.getStartdate() != null
					&& formbean.getEnddate() != null) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append(" o.filldate >=?" + (params.size() + 1));
				params.add(formbean.getStartdate());
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append("  o.filldate  <= ?" + (params.size() + 1));

				params.add(formbean.getEnddate());
			}
			
		}
		
		orderby.put("filldate", "desc");
		pageView.setQueryResult(otherService.getScrollData(pageView.getFirstResult(), 
				pageView.getMaxresult(), jpql.toString(), params.toArray(), orderby));
		request.setAttribute("pageView", pageView);		
		return mapping.findForward("list");
	}

}
