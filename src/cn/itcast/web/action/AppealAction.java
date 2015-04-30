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
import cn.itcast.bean.Appeal;
import cn.itcast.service.AppealService;
import cn.itcast.web.formbean.AppealForm;


@Controller("/control/appeal/list")
public class AppealAction extends Action {
	@Resource(name="appealServiceImpl")
	private AppealService appealService;

	@Override 
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		AppealForm formbean = (AppealForm) form;
		StringBuffer jpql = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		PageView<Appeal> pageView = new PageView<Appeal>(12, formbean.getPage());
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
			if (formbean.getRankid() != null && formbean.getRankid() > 0) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append(" o.rank.id=?" + (params.size() + 1));
				params.add(formbean.getRankid());
			}
			
		}
		
		orderby.put("filldate", "desc");
		pageView.setQueryResult(appealService.getScrollData(pageView.getFirstResult(), 
				pageView.getMaxresult(), jpql.toString(), params.toArray(), orderby));
		request.setAttribute("pageView", pageView);		
		return mapping.findForward("list");
	}

}
