package com.redick.view.controller;

import com.redick.persistencia.dao.CursoDAO;
import com.redick.persistencia.entidade.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by alisonmoura on 05/08/15.
 */
@RequestMapping("/curso")
@Controller
public class CursoController {

    @Autowired
    CursoDAO dao;

    @RequestMapping("/novo")
    public String formcurso(){

        return "formcurso";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String salvar(Curso curso){

        dao.salvar(curso);

        return "forward:/curso/listar";
    }

    @RequestMapping("/listar")
    public String listar(HttpServletRequest request){

        //Traz todos os cursos do banco
        List<Curso> lista = dao.buscarTodos();

        //Coloca a lista no request
        request.setAttribute("lista-cursos", lista);

        return "forward:/WEB-INF/views/lista-cursos.jsp";
    }

}
