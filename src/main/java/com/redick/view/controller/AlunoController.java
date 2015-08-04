package com.redick.view.controller;

import com.redick.persistencia.dao.AlunoDAO;
import com.redick.persistencia.entidade.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by alisonmoura on 04/08/15.
 */

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoDAO dao;

    public AlunoController() {

    }

    @RequestMapping(value = "/lista-alunos")
    public String listarAlunos(HttpServletRequest request) {

        //Pegar a lista de alunos no banco de dados
        List<Aluno> listaAlunos = dao.buscarTodos();

        //Colocar a lista no request
        request.setAttribute("listaalunos", listaAlunos);

        //Leva para a página de listar alunos
        return "forward:/WEB-INF/views/lista-alunos.jsp";
    }

}
