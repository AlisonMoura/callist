package com.redick.view.controller;

import com.redick.persistencia.dao.UsuarioDAO;
import com.redick.persistencia.entidade.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by alisonmoura on 26/07/15.
 */

@Controller
public class LoginController {

    @Autowired
    UsuarioDAO dao;



    public LoginController() {
    }

    //Método que será invocado assim que a classe for chamada
    @PostConstruct
    public void init() {
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST, params = {"login", "senha"})
    public String login(@RequestParam String login, @RequestParam String senha, HttpServletRequest request, HttpSession session) {

        //Instancia e seta o login e a senha no usuarioAutenticar a ser autenticado pelo UsuarioDAO
        Usuario usuAutenticar = new Usuario();
        usuAutenticar.setLogin(login);
        usuAutenticar.setSenha(senha);

        //Mensagem para ser levada para a tela
        String msg;

        try {

            //Pede ao usuarioDAO para autenticar o usuario
            Usuario usuAutenticado = dao.autenticar(usuAutenticar);

            System.out.println("Imprimindo o Usuário: ");
            System.out.println(usuAutenticado.toString());

            //Colocando o usuario autenticado na sessão que o spring já me fornece
            session.setAttribute("usuario", usuAutenticado);

            //redireciona para a página principal
            return "index";

        }catch (NoResultException e){

            //Imprime a exception
            e.printStackTrace();

            //Coloca a mensagem no request
            msg = "Usuário não encontrado!";

            //Coloca a mensagem no request
            request.setAttribute("msg",msg);

            //redireciona para o login.jsp
            return "forward:login.jsp";
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){

        //Verifica se a sessão não está nula, antes de invalidadá-la
        if(session!=null){
            session.invalidate();
        }
        return "redirect:login.jsp";
    }

}
