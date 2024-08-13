package com.exalt.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("theDate", new java.util.Date());
        return "helloworld"; // --> src/main/resources/templates/helloworld.html
    }

    @GetMapping("/home")
    public String showHome(){
        return "home";
    }

    @GetMapping("/showMyLoginPage")
    public String showLoginPage(){
        System.out.println("-----------------------------------------------------------------");
        return "plain-login";
    }
}
