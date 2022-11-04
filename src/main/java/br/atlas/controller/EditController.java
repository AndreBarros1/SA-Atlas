package br.atlas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditController {

    @GetMapping
    public String edit(){
        return "/home/edit";
    }

}
