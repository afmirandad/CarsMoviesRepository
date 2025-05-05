package com.carsmoviesfrontend.app.models;

import lombok.Data;

@Data
public class Movie {
    private String id;
    private String carMovieName;
    private String carMovieYear;
    private Integer duration;
}
