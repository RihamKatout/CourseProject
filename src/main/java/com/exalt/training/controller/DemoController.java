package com.exalt.training.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/test")
    public String testMapping(){
        return "Hellooooooo";
    }

    @GetMapping("/devTools")
    public String devToolsTest(){
        return "devTools is a good man :)";
    }

    @GetMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("theDate", new java.util.Date());
        return "helloword"; // --> src/main/resources/templates/helloworld.html
    }
}
