package cn.vaf714.shop.filter;

import cn.vaf714.shop.entity.UserVo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginFilter implements Filter {
	String[] addminUrls = null;
	String[] generalUserUrls = null;

    public LoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		HttpSession session = request.getSession();
		//判断是否需要管理员登录
		for (String s : addminUrls) {
			if (s.equals(request.getServletPath())) {// 判断是否需要权限
				UserVo user = (UserVo) session.getAttribute("adminUser");
				
				if (user != null) {// 2.判断是否登陆过
					chain.doFilter(arg0, arg1);
				}else {
					response.sendRedirect("admin_login.html");
				}
				return;
			}
		}
		//判断是否需要普通用户登录
		for (String s : generalUserUrls) {
			if (s.equals(request.getServletPath())) {// 判断是否需要权限
				UserVo user = (UserVo) session.getAttribute("generalUser");
				
				if (user != null) {// 2.判断是否登陆过
					chain.doFilter(arg0, arg1);
				}else {
					response.sendRedirect("user_login.html");
				}
				return;
			}
		}
		chain.doFilter(arg0, arg1);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.addminUrls = fConfig.getServletContext().getInitParameter("adminUrls").split(",");
		this.generalUserUrls = fConfig.getServletContext().getInitParameter("generalUserUrls").split(",");
	}

}
