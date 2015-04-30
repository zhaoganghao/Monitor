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
import org.springframework.stereotype.Controller;

import cn.itcast.bean.User;
import cn.itcast.service.UserService;
import cn.itcast.utils.SiteUrl;
import cn.itcast.web.formbean.UserForm;

@Controller("/control/user/manage")
public class UserManageAction extends DispatchAction {
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	public ActionForward queryUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {		
		return mapping.findForward("query");
	}
	public ActionForward editUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserForm formbean = (UserForm) form;
		User user = userService.find(formbean.getId());
		formbean.setUsername(user.getUsername());
		formbean.setPassword(user.getPassword());
		formbean.setEmail(user.getEmail());
		formbean.setPhone(user.getPhone());
		return mapping.findForward("edit");
	}
	public ActionForward updateUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserForm formbean = (UserForm) form;
		User user = (User) request.getSession().getAttribute("user");
		formbean.setUsername(user.getUsername());
		formbean.setPassword(user.getPassword());
		formbean.setEmail(user.getEmail());
		formbean.setPhone(user.getPhone());
		formbean.setId(user.getId());
		return mapping.findForward("update");
	}
	
	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserForm formbean = (UserForm) form;
		User user=new User(formbean.getUsername(), formbean.getPassword(), formbean.getEmail(), formbean.getPhone(), 2);
		user.setId(formbean.getId());
		userService.update(user);
		request.setAttribute("message", "修改成功");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.user.list"));
		return mapping.findForward("message");
	}
	public ActionForward download1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("download1");
	}
	public ActionForward download2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("download2");
	}
	public ActionForward download3(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("download3");
	}
	public ActionForward download4(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("download4");
	}
	public ActionForward download5(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("download5");
	}
	public ActionForward download6(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("download6");
	}
	public ActionForward download7(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("download7");
	}
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserForm formbean = (UserForm) form;
		User user = (User) request.getSession().getAttribute("user");
		User user2=new User(formbean.getUsername(), formbean.getPassword(), formbean.getEmail(), formbean.getPhone());
		user2.setId(formbean.getId());
		user2.setType(user.getType());
		try {
			userService.update(user2);
		} catch (Exception e) {
			request.setAttribute("message", "用户名已近存在,请用其他用户名");
			request.setAttribute("urladdress", SiteUrl.readUrl("control.user.list"));
			return mapping.findForward("message");
		}
		request.getSession().setAttribute("user", userService.find(formbean.getId()));
		request.setAttribute("message", "修改成功");
		request.setAttribute("urladdress", "control/center/index.do");
		return mapping.findForward("success");
	}
	
	public ActionForward addUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("add");
	}
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserForm formbean = (UserForm) form;
		userService.delete(formbean.getId());
		request.setAttribute("message", "删除成功");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.user.list"));
		return mapping.findForward("message");
	}
	
	/**
	 * 品牌添加
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserForm formbean = (UserForm) form;
		User user=new User(formbean.getUsername(), formbean.getPassword(), formbean.getEmail(), formbean.getPhone(), 2);
		try {
			userService.save(user);
		} catch (Exception e) {
			request.setAttribute("message", "用户名已近存在,请用其他用户名");
			request.setAttribute("urladdress", SiteUrl.readUrl("control.user.list"));
			return mapping.findForward("message");
		}
		request.setAttribute("message", "用户添加成功");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.user.list"));
		return mapping.findForward("message");
	}
}
