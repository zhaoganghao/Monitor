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
import cn.itcast.bean.Result;
import cn.itcast.service.QuestionTypeService;
import cn.itcast.service.ResultService;
import cn.itcast.web.formbean.ResultForm;

@Controller("/control/result/list")
public class ResultAction extends Action {
	@Resource(name = "resultServiceImpl")
	private ResultService resultService;
	@Resource(name = "questionTypeServiceImpl")
	private QuestionTypeService questionTypeService;
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ResultForm formbean = (ResultForm) form;
		StringBuffer jpql = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		if ("true".equals(formbean.getQuery())) {
			if (formbean.getMainbehaviorid() != null && formbean.getMainbehaviorid() > 0) {
				List<Integer> typeids = new ArrayList<Integer>();
				typeids.add(formbean.getMainbehaviorid());
				List<Integer> subTypeid=questionTypeService.getSubTypeid(new Integer[]{formbean.getMainbehaviorid()});
				typeids.addAll(subTypeid);
				StringBuffer n = new StringBuffer();
				for(int i=0; i<typeids.size();i++){
					n.append('?').append((i+1)).append(',');
				}
				n.deleteCharAt(n.length()-1);
				jpql.append("  o.mainbehavior.id in("+ n.toString()+ ")");
				params.addAll(typeids);
				
			}
			if (formbean.getNextbehaviorid() != null && formbean.getNextbehaviorid() > 0) {
				List<Integer> typeids = new ArrayList<Integer>();
				typeids.add(formbean.getNextbehaviorid() );
				List<Integer> subTypeid=questionTypeService.getSubTypeid(new Integer[]{formbean.getNextbehaviorid() });
				typeids.addAll(subTypeid);
				StringBuffer n = new StringBuffer();
				int j=params.size();
				for(int i=0; i<typeids.size();i++){
					n.append('?').append((j+i+1)).append(',');
				}
				n.deleteCharAt(n.length()-1);
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append("  o.nextbehavior.id in("+ n.toString()+ ")");
				params.addAll(typeids);
				
			}
			if (formbean.getSourcetwo() != null
					&& !"".equals(formbean.getSourcetwo().trim())) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append(" o.sourcetwo like ?" + (params.size() + 1));
				params.add("%" + formbean.getSourcetwo() + "%");
			}
			if (formbean.getIndexcode() != null
					&& !"".equals(formbean.getIndexcode().trim())) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append(" o.indexcode like ?" + (params.size() + 1));
				params.add("%" + formbean.getIndexcode() + "%");
			}
			if (formbean.getBriefinfor()!= null
					&& !"".equals(formbean.getBriefinfor().trim())) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append(" o.briefinfor like ?" + (params.size() + 1));
				params.add("%" + formbean.getBriefinfor() + "%");
			}

			if (formbean.getPersoncode() != null
					&& !"".equals(formbean.getPersoncode().trim())) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append("  o.personcode like ?" + (params.size() + 1));

				params.add("%" + formbean.getPersoncode() + "%");
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
				jpql.append("   o.rank.id=?" + (params.size() + 1));

				params.add(formbean.getRankid());
			}
			if (formbean.getRankid() != null && formbean.getRankid() > 0) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append(" o.rank.id=?" + (params.size() + 1));
				params.add(formbean.getRankid());
			}

		}
		PageView<Result> pageView = new PageView<Result>(12,
				formbean.getPage());
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("filldate", "desc");
		pageView.setQueryResult(resultService.getScrollData(
				pageView.getFirstResult(), pageView.getMaxresult(),
				jpql.toString(), params.toArray(), orderby));
		request.setAttribute("pageView", pageView);
		return mapping.findForward("list");
	}

}
