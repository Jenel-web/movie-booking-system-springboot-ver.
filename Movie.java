package com.learning.bookMovieApplication.Entity;

import jakarta.persistence.*;

@Entity
@Table (name = "movie")
public class Movie {
    @Id
    @GeneratedValue
    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "title")
    private String title;

    @Column(name = "theater")
    private String theater;

    @Column(name = "vip_seat_limit")
    private Integer vipSeatLimit = 50;

    @Column(name = "vip_seat_booked")
    private Integer vipSeatBooked = 0;

    @Column(name = "reg_seat_limit")
    private Integer regSeatLimit = 50;

    @Column(name = "reg_seat_booked")
    private Integer regSeatBooked = 0;

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getRegSeatBooked() {
        return regSeatBooked;
    }

    public void setRegSeatBooked(Integer regSeatBooked) {
        this.regSeatBooked = regSeatBooked;
    }

    public Integer getRegSeatLimit() {
        return regSeatLimit;
    }

    public void setRegSeatLimit(Integer regSeatLimit) {
        this.regSeatLimit = regSeatLimit;
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

    public Integer getVipSeatBooked() {
        return vipSeatBooked;
    }

    public void setVipSeatBooked(Integer vipSeatBooked) {
        this.vipSeatBooked = vipSeatBooked;
    }

    public Integer getVipSeatLimit() {
        return vipSeatLimit;
    }

    public void setVipSeatLimit(Integer vipSeatLimit) {
        this.vipSeatLimit = vipSeatLimit;
    }
}

