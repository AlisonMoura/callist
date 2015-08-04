package com.redick.view.filters;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by alisonmoura on 03/08/15.
 */


public class FilterHandler extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //Pegando a sessão
        HttpSession session = request.getSession();

        //pegando a url
        String url = request.getRequestURI();

        if (session.getAttribute("usuario") == null && (url.endsWith("/callist/") || url.endsWith("/callist"))) {

            request.getRequestDispatcher("login.jsp").forward(request, response);

            return true;

        } else if (session.getAttribute("usuario") != null || url.endsWith("login.jsp/") || url.endsWith("login.jsp") || url.endsWith("login/") || url.endsWith("login")) {

            return true;

        } else {

            //Faz a mensagem de erro
            String msg = "Loge-se para continuar!";

            //coloca a mensagem como atributo no request
            request.setAttribute("msg",msg);

            //manda devolta para o login
            request.getRequestDispatcher("login.jsp").forward(request, response);

            //retorna false
            return false;
        }

    }


}
