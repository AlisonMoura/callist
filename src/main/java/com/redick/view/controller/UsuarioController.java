package com.redick.view.controller;

import com.redick.persistencia.dao.UsuarioDAO;
import com.redick.persistencia.entidade.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by alisonmoura on 14/07/15.
 */

@Controller
@RequestMapping("/usuario")
public class UsuarioController extends HttpServlet {

    @Autowired
    private UsuarioDAO dao;

    public UsuarioController() {

    }

    @RequestMapping("/lista-usuarios")
    public String listar(HttpServletRequest request) {

        //Pega a lista de usuários pelo DAO
        List<UsuarioDAO> listaUsu = (List) dao.buscarTodos();

        //Coloca a lista no Request
        request.setAttribute("listausuarios", listaUsu);

        return "forward:/WEB-INF/views/lista-usuarios.jsp";

    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String cadastrar(Usuario usuario) {

        if (usuario != null) {
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Login: " + usuario.getLogin());
            System.out.println("Senha: " + usuario.getSenha());

            dao.salvar(usuario);
        }

        return "forward:/WEB-INF/views/lista-usuarios.jsp";
    }


    @RequestMapping(value = "/formusu",method = RequestMethod.GET)
    public String formusu(){

        return "formusu";
    }

}
