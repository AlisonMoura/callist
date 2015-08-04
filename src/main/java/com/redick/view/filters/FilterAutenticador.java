package com.redick.view.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by alisonmoura on 26/07/15.
 */

@WebFilter(dispatcherTypes = {DispatcherType.REQUEST}, urlPatterns = {"/*"})
public class FilterAutenticador implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //Fazendo o cast do request e response para o HttpServlet{service}
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        //pega a url da requisição
        String url = req.getRequestURI();

        //pega a sessão do http
        HttpSession session = req.getSession();

        System.out.println(url);

        if (session.getAttribute("usuario") == null && (url.endsWith("/callist/") || url.endsWith("/callist"))) {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else if (session.getAttribute("usuario") != null || url.lastIndexOf("login.jsp") > -1 || url.lastIndexOf("login") > -1 || url.lastIndexOf("logout") > -1 || url.contains("resources") || url.contains("includes")) {
            chain.doFilter(req, resp);
        } else {

            //Faz a mensagem de erro
            String msg = "Loge-se para continuar!";

            //coloca a mensagem como atributo no request
            req.setAttribute("msg", msg);

            //redireciona o request para o login.jsp
            req.getRequestDispatcher("/login.jsp").forward(req, resp);

        }

    }

    public void destroy() {

    }
}
