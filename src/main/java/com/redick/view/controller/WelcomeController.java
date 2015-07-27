package com.redick.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by alisonmoura on 26/07/15.
 */
@Controller
public class WelcomeController {

    @RequestMapping("/callist")
    public String welcome(){
        return "index";
    }

}
