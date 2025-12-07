package com.learning.bookMovieApplication.Entity;


import com.learning.bookMovieApplication.DTO.SeatCategory;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue
    @Column(name = "ticket_id")
    private Integer ticketId;

    @Column(name = "seat_category")
    @Enumerated(EnumType.STRING)
    private SeatCategory seatCategory;
    @Column(name = "ticket_code")
    private String ticketCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id")
    private Movie movie;//will be changed once I learned Spring Data JPA


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user; //will be changed once I learned Spring Data JPA

    @Column(name = "time_booked", insertable = false, updatable = false)
    private LocalDateTime timeBooked;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public LocalDateTime getTimeBooked() { return timeBooked; }
}
