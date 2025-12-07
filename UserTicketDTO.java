package com.learning.bookMovieApplication.DTO;

public class UserTicketDTO {

    private SeatCategory seatCategory;
    private String ticketCode;
    private String title;
    private String theater;
    private String userName;

    public UserTicketDTO( String ticketCode,SeatCategory seatCategory,
     String title,
     String theater,
     String userName) {

        this.seatCategory = seatCategory;
        this.ticketCode = ticketCode;
        this.title = title;
        this.theater = theater;
        this.userName = userName;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
