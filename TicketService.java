package com.learning.bookMovieApplication.Service;


import com.learning.bookMovieApplication.DTO.SeatCategory;
import com.learning.bookMovieApplication.DTO.UserTicketDTO;
import com.learning.bookMovieApplication.Entity.Movie;
import com.learning.bookMovieApplication.Entity.Ticket;
import com.learning.bookMovieApplication.Entity.User;
import com.learning.bookMovieApplication.Repository.MovieRepository;
import com.learning.bookMovieApplication.Repository.TicketRepository;
import com.learning.bookMovieApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    UserRepository userRepository;

    SeatCategory seatCategory;
    public void bookTicket(String username, Integer movieId, SeatCategory seatCategory, String ticketCode){
        Ticket ticket = new Ticket();

        //User Checking
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found")); //makes a user which is the found user.

        //Movie Checking
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));//makes a movie from the found movie

        //Available Seats Checking
        if(seatCategory.equals(SeatCategory.VIP) && movie.getVipSeatBooked() == movie.getVipSeatLimit()){
            throw new RuntimeException("No VIP seats available.");
        }
        else if(seatCategory.equals(SeatCategory.REGULAR) && movie.getRegSeatBooked() == movie.getRegSeatLimit()){
            throw new RuntimeException("No Regular seats available,");
        }
        else{
            ticket.setUser(user);// user found is used here.
            ticket.setMovie(movie);
            ticket.setTicketCode(ticketCode);
            ticket.setSeatCategory(seatCategory);
        }

        ticketRepository.save(ticket);
        incrementTicket(ticket);
        return;
    }

    public void incrementTicket(Ticket t){
        SeatCategory seatCategory = t.getSeatCategory();
        Movie m = t.getMovie();


        if(seatCategory.equals(SeatCategory.VIP)){
            Integer seats = m.getVipSeatBooked();
            m.setVipSeatBooked(seats + 1);
            movieRepository.save(m);
        }
        else{
            Integer seats = m.getRegSeatBooked();
            m.setRegSeatBooked(seats + 1);
            movieRepository.save(m);
        }
    }
    public List<UserTicketDTO> showUserBooking(Integer userId){
            return ticketRepository.findByUserUserId(userId);
    }

    public List<UserTicketDTO> showMovieTickets(Integer movieId){
        return ticketRepository.findByMovieMovieId(movieId);
    }

    public boolean cancelTicket(String ticketCode){

        Optional<Ticket> ticket = ticketRepository.findByTicketCode(ticketCode);

        Ticket t = ticket.orElseThrow(() ->new RuntimeException("Ticket not found."));


        decrementTicket(t);
        ticketRepository.delete(t);

        return true;
    }

    public void decrementTicket(Ticket t){

        SeatCategory seatCategory = t.getSeatCategory();
        Movie m = t.getMovie();


        if(seatCategory.equals(SeatCategory.VIP)){
            Integer seats = m.getVipSeatBooked();
            m.setVipSeatBooked(seats - 1);
            movieRepository.save(m);
        }
        else{
            Integer seats = m.getRegSeatBooked();
            m.setRegSeatBooked(seats - 1);
            movieRepository.save(m);
        }

    }

}
