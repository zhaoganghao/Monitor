package cn.itcast.web.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import cn.itcast.service.UserService;
import cn.itcast.utils.SiteUrl;
import cn.itcast.web.formbean.UserForm;


@Controller("/user/login")
public class LoginAction extends Action {
	@Resource (name="userServiceImpl")
	private UserService userService;
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm formbean = (UserForm) form;
		if(formbean.getUsername()!=null && !"".equals(formbean.getUsername().trim())
				&& formbean.getPassword()!=null && !"".equals(formbean.getPassword().trim())){
			if(userService.checkUser(formbean.getUsername().trim(), formbean.getPassword().trim())){				
				request.getSession().setAttribute("user", userService.find(formbean.getUsername().trim()));
				return mapping.findForward("success");
			}
			request.setAttribute("message", "用户名或密码有误");
		}
		return mapping.findForward("login");
	}
}
