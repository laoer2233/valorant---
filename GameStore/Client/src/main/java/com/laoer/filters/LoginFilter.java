
package com.laoer.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


/**
 * @author Laoer
 * @version 2021.3
 * @date 2024/12/16 21:22
 */


@WebFilter(urlPatterns = {"/index.html/*"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
        HttpSession session = httpServletRequest.getSession();

        Object sysUser = session.getAttribute("system");
        if(null==sysUser){
            httpServletResponse.sendRedirect("/login.html");
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}

