package com.learning.bookMovieApplication.Controller;


import com.learning.bookMovieApplication.DTO.MovieDTO;
import com.learning.bookMovieApplication.DTO.SeatCategory;
import com.learning.bookMovieApplication.DTO.UserTicketDTO;
import com.learning.bookMovieApplication.Entity.Ticket;
import com.learning.bookMovieApplication.Entity.User;
import com.learning.bookMovieApplication.Repository.UserRepository;
import com.learning.bookMovieApplication.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/booking/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/book")
    public ResponseEntity<String> bookTicket(@RequestParam String username,
                                             @RequestParam Integer movieId,
                                             @RequestParam SeatCategory seatCategory) {

        String ticketCode = UUID.randomUUID().toString().substring(0, 6);
        ticketService.bookTicket(username, movieId, seatCategory, ticketCode);

        return ResponseEntity.ok("Ticket booked Successfully!");

    }

    @GetMapping("/booked")
    public List<UserTicketDTO> showUserBooking(@RequestParam("userId") Integer userId) {
        return ticketService.showUserBooking(userId);
    }


    @GetMapping("/movieTickets")
    public List<UserTicketDTO> showMovieTickets(@RequestParam("movieId") Integer movieId) {
        return ticketService.showMovieTickets(movieId);
    }

    @DeleteMapping("/cancel/{ticketCode}")
    public ResponseEntity<String> cancelTicket(@PathVariable("ticketCode") String ticketCode) {
        boolean isCancelled = ticketService.cancelTicket(ticketCode);

        if (isCancelled) {
            return ResponseEntity.ok("Ticket Cancelled Successfully.: ");
        } else {
            return ResponseEntity.ok("Ticket Cancellation Failed.");
        }

    }

}
