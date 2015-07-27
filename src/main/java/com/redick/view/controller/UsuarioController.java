package com.redick.view.controller;

import com.redick.persistencia.dao.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;
import java.io.IOException;

/**
 * Created by alisonmoura on 14/07/15.
 */

@Controller
@RequestMapping("/usuario")
public class UsuarioController extends HttpServlet{

    @Autowired
    private UsuarioDAO dao;

    public UsuarioController(){

    }

    @RequestMapping("/lista-usuarios")
    public String listar(){

        System.out.println("Listando usuários cadastrados no sistema!");

        return "listausuarios";

    }

}
