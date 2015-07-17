package com.redick.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by alisonmoura on 14/07/15.
 */

@Controller
@RequestMapping("/usucontroller")
public class UsuarioController {

    @RequestMapping("/listar")
    public String listar(){

        System.out.println("Listando usuários cadastrados no sistema!");

        return "listausuarios";

    }

}
