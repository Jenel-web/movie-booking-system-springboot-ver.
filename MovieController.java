package com.learning.bookMovieApplication.Controller;


import com.learning.bookMovieApplication.DTO.MovieDTO;
import com.learning.bookMovieApplication.Entity.Movie;
import com.learning.bookMovieApplication.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/list")
    public List<MovieDTO> findAll(){
        return movieService.findAll();
    }

    @PostMapping("/admin/addMovie")
    public ResponseEntity<String> addMovie(@RequestParam String title,
                                           @RequestParam String theater){
        movieService.addMovie(title, theater);

        return ResponseEntity.ok("Movie added Successfully.");
    }

    @DeleteMapping("/admin/removeMovie")
    public ResponseEntity<String> removeMovie(@RequestParam Integer movieId){
        movieService.removeMovie(movieId);
        return ResponseEntity.ok("Movie Deleted Successfully!");
    }
}
