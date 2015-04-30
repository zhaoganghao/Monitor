package cn.itcast.web.filter;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.velocity.app.Velocity;

import cn.itcast.web.formdatetype.converter.DateConverter;



public class UserFilter implements Filter {

	public void destroy() {}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filterchain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		if(request.getSession().getAttribute("user")!=null){
			filterchain.doFilter(request, response);
			return;
		}else{
			response.sendRedirect(request.getContextPath()+"/login.do");
			return;
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
