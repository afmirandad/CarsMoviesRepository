package com.carsmoviesfrontend.app.controllers;

import com.carsmoviesfrontend.app.models.PagedResponse;
import com.carsmoviesfrontend.app.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  // FALTABA ESTO
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoviesController {

    private final MoviesService movieService;

    @Autowired
    public MoviesController(MoviesService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public String listMovies(@RequestParam(defaultValue = "0") int page, Model model) {
        PagedResponse response = movieService.getAllMovies(page);
        model.addAttribute("response", response);
        model.addAttribute("movies", response.getMovies());
        model.addAttribute("currentPage", response.getCurrentPage());
        model.addAttribute("totalPages", response.getTotalPages());
        return "movies";
    }
}
