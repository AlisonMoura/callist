package com.redick.view.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by alisonmoura on 26/07/15.
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST}, urlPatterns = {"/WEB-INF/*"})
public class FilterAutenticador implements Filter{

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }

    public void destroy() {

    }
}
