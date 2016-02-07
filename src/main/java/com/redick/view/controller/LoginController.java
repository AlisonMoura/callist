package com.redick.view.controller;

import com.redick.persistencia.dao.UsuarioDAO;
import com.redick.persistencia.entidade.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UsuarioDAO dao;


    public LoginController() {
    }

    @PostConstruct
    public void init() {
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST, params = {"login", "senha"})
    public String login(@RequestParam String login, @RequestParam String senha, HttpServletRequest request, HttpSession session) {

        Usuario usuAutenticar = new Usuario();
        usuAutenticar.setLogin(login);
        usuAutenticar.setSenha(senha);

        String msg;

        try {

            Usuario usuAutenticado = dao.autenticar(usuAutenticar);

            System.out.println("Imprimindo o Usuário: ");
            System.out.println(usuAutenticado.toString());

            session.setAttribute("usuario", usuAutenticado);

            return "index";

        } catch (NoResultException e) {

            e.printStackTrace();

            msg = "Usuário não encontrado!";

            request.setAttribute("msg", msg);

            return "forward:login.jsp";
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
        return "redirect:login.jsp";
    }

}
