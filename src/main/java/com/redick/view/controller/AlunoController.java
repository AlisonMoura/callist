package com.redick.view.controller;

import com.redick.persistencia.dao.AlunoDAO;
import com.redick.persistencia.entidade.Aluno;
import com.redick.persistencia.entidade.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping("/novo")
    public String formAluno(HttpServletRequest request) {

        return "formaluno";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String salvarAluno(Aluno aluno, HttpServletRequest request) {

        dao.salvar(aluno);

        request.setAttribute("msg", "Salvo com sucesso!");

        return "forward:/aluno/lista-alunos";
    }

    @RequestMapping(value = "/lista-alunos")
    public String listarAlunos(HttpServletRequest request) {

        List<Aluno> listaAlunos = dao.buscarTodos();

        request.setAttribute("listaalunos", listaAlunos);

        return "forward:/WEB-INF/views/lista-alunos.jsp";
    }
}
