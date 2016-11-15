package my.it.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import my.it.core.constant.Constant;
import my.it.core.permission.PermissionCheck;
import my.it.nsfw.user.entity.User;

/**
 * 过滤器需要实现  servlet 的 filter接口     且需要在web.xml中的struts前面配置
 * @author llp
 *
 */


public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String uri = request.getRequestURI();
		//判断是否是登陆请求地址
		if(!uri.contains("sys/login_")){
			//非登陆请求
			//判断是否已经登陆
			if(request.getSession().getAttribute(Constant.USER) != null){
				//说明已经登陆   
				//判断是否访问纳税服务子系统
				if(uri.contains("/nsfw/")){
					//访问nsfw系统
					User user = (User)request.getSession().getAttribute(Constant.USER);
					//获取ioc容器
					WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
					PermissionCheck permissionCheck = (PermissionCheck) applicationContext.getBean("permissionCheck");
					
					if(permissionCheck.isAccessible(user,"nsfw")){
						//说明有权限放行
						chain.doFilter(request, response);
					}else{
						//没有权限  转到没有权限提示页面
						response.sendRedirect(request.getContextPath()+"/sys/login_toNoPermissionUI.action");
					}
				}else{
					//非访问nsfw页面直接放行
					chain.doFilter(request, response);
				}
			}else{
				//没有登陆  跳转到登陆页面
				response.sendRedirect(request.getContextPath()+"/sys/login_toLoginUI.action");
			}
			
		}else{
			//登陆请求
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
