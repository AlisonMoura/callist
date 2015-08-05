package com.redick.view.controller;

import com.redick.persistencia.dao.AlunoDAO;
import com.redick.persistencia.entidade.Aluno;
import com.redick.persistencia.entidade.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

        //Salva o aluno
        dao.salvar(aluno);

        //Mensagem para a tela
        String msg = "Salvo com sucesso!";

        //Colocando a mensagem no request
        request.setAttribute("msg", msg);

        return "forward:/aluno/lista-alunos";
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
