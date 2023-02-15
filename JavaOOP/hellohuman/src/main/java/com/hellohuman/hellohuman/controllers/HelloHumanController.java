package com.hellohuman.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloHumanController {
    @GetMapping(value="/")
    public String getIndex() {
        return "index.jsp";
    }
    
}
