
package com.carsmoviesfrontend.app.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MoviesController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}