package br.atlas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeedController {

    @GetMapping
    public String feed(){
        return "/home/feed";
    }

}
