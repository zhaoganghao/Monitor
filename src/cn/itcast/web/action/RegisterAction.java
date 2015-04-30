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
import cn.itcast.bean.Register;
import cn.itcast.service.QuestionTypeService;
import cn.itcast.service.RegisterService;
import cn.itcast.web.formbean.RegisterForm;

@Controller("/control/register/list")
public class RegisterAction extends Action {
	@Resource(name = "registerServiceImpl")
	private RegisterService registerService;
	@Resource(name = "questionTypeServiceImpl")
	private QuestionTypeService questionTypeService;
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
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
				jpql.append("  o.type.id in("+ n.toString()+ ")");
				params.addAll(typeids);
				
			}
			if (formbean.getReportedname()!= null
					&& !"".equals(formbean.getReportedname().trim())) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append(" o.reportedname like ?" + (params.size() + 1));
				params.add("%" + formbean.getReportedname() + "%");
			}
			if (formbean.getIndexcode() != null
					&& !"".equals(formbean.getIndexcode().trim())) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append(" o.indexcode like ?" + (params.size() + 1));
				params.add("%" + formbean.getIndexcode() + "%");
			}
			if (formbean.getSourcetwo() != null
					&& !"".equals(formbean.getSourcetwo().trim())) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append(" o.sourcetwo like ?" + (params.size() + 1));
				params.add("%" + formbean.getSourcetwo() + "%");
			}
			if (formbean.getHandlernumber() != null
					&& !"".equals(formbean.getHandlernumber().trim())) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append(" o.handlernumber like ?" + (params.size() + 1));
				params.add("%" + formbean.getHandlernumber()+ "%");
			}
			if (formbean.getSourcenumber()!= null
					&& !"".equals(formbean.getSourcenumber().trim())) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append(" o.sourcenumber like ?" + (params.size() + 1));
				params.add("%" + formbean.getSourcenumber()+ "%");
			}

			if (formbean.getPersoncode() != null
					&& !"".equals(formbean.getPersoncode().trim())) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append("  o.personcode like ?" + (params.size() + 1));

				params.add("%" + formbean.getPersoncode() + "%");
			}
			if (formbean.getMainthread() != null
					&& !"".equals(formbean.getMainthread().trim())) {
				if (params.size() > 0)
					jpql.append(" and ");
				jpql.append("  o.mainthread like ?" + (params.size() + 1));
				
				params.add("%" + formbean.getMainthread() + "%");
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

			if (formbean.getIspunish() != null && formbean.getIspunish() >= 0) {
				if (formbean.getIspunish() == 0) {
					if (params.size() > 0) {
						jpql.append(" and");
					}
					jpql.append("  o.size = 0");
				} else if (formbean.getIspunish() == 1) {
					if (params.size() > 0) {
						jpql.append(" and");
					}
					jpql.append("  o.size= 1");
				} else if (formbean.getIspunish() == 2) {
					if (params.size() > 0) {
						jpql.append(" and");
					}
					jpql.append("  o.size = 2");
				} else if (formbean.getIspunish() == 3) {
					if (params.size() > 0) {
						jpql.append(" and");
					}
					jpql.append("  o.size = 3");
				}
			}

		}
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

}
