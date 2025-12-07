package com.learning.bookMovieApplication.Service;


import com.learning.bookMovieApplication.DTO.MovieDTO;
import com.learning.bookMovieApplication.Entity.Movie;
import com.learning.bookMovieApplication.Repository.MovieRepository;
import com.learning.bookMovieApplication.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TicketRepository ticketRepository;
    MovieDTO movieDTO;
    public List<MovieDTO> findAll(){
        Iterable<Movie> findAllApplicants = movieRepository.findAll();
        List <Movie> movies = new ArrayList<>();
        findAllApplicants.forEach(movies::add);
        List<MovieDTO> allMovies = new ArrayList<>();
        for(Movie a: movies){
          allMovies.add(movieDTO.from(a)); // converts the movie to movieDTO which will be showed to the users
        }
        return allMovies;
    }

    public String addMovie(String title, String theater){
        Movie movie = new Movie();

        movie.setTitle(title);
        movie.setTheater(theater);

        movieRepository.save(movie);

        return "Movie added Successfully!";

    }

    public String removeMovie(Integer movieId){
         movieRepository.deleteById(movieId);
         ticketRepository.deleteTicketByMovieMovieId(movieId);

         return "Movie Deleted.";
    }

}
