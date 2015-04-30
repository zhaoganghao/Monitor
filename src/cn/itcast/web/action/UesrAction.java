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
import cn.itcast.bean.User;
import cn.itcast.service.UserService;
import cn.itcast.web.formbean.UserForm;


@Controller("/control/user/list")
public class UesrAction extends Action {
	@Resource(name="userServiceImpl")
	private UserService userService;

	@Override 
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserForm formbean = (UserForm) form;
		StringBuffer jpql = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
			jpql.append("  o.type = ?"+ (params.size()+1));
			params.add(2);
		PageView<User> pageView = new PageView<User>(12, formbean.getPage());
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("regtime", "desc");
		pageView.setQueryResult(userService.getScrollData(pageView.getFirstResult(), 
				pageView.getMaxresult(), jpql.toString(), params.toArray(), orderby));
		request.setAttribute("pageView", pageView);		
		return mapping.findForward("list");
	}

}
