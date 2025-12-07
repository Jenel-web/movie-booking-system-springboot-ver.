package com.learning.bookMovieApplication.DTO;

import com.learning.bookMovieApplication.Entity.Movie;
import org.jetbrains.annotations.NotNull;

public class MovieDTO {

    private String title;
    private String theater;

    public MovieDTO(String title, String theater) {
        this.title = title;
        this.theater = theater;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static MovieDTO from(@NotNull Movie movie){
        return new MovieDTO(movie.getTitle(),movie.getTheater());
    }
}
