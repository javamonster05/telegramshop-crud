package com.javamonster.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {
    @RequestMapping("/")
    @ResponseBody
    public String home(){
        return "<h1>Home<h2>\n" +
                "<a href=\"/suppliers\">Suppliers</a><br>"+
                "<a href=\"/products\">Products</a><br>";
    }
}
