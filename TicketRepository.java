package com.learning.bookMovieApplication.Repository;

import com.learning.bookMovieApplication.DTO.TicketDTO;
import com.learning.bookMovieApplication.DTO.UserTicketDTO;
import com.learning.bookMovieApplication.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer > {

    @Query("""
        SELECT new com.learning.bookMovieApplication.DTO.UserTicketDTO(
            t.ticketCode,
            t.seatCategory,
            m.title,
            m.theater,
            u.userName
        )
        FROM Ticket t
        JOIN t.movie m
        JOIN t.user u
        WHERE t.user.userId = :userId
        """)
    List<UserTicketDTO> findByUserUserId (Integer userId);

    @Query("""
        SELECT new com.learning.bookMovieApplication.DTO.UserTicketDTO(
            t.ticketCode,
            t.seatCategory,
            m.title,
            m.theater,
            u.userName
        )
        FROM Ticket t
        JOIN t.movie m
        JOIN t.user u
        WHERE t.movie.movieId = :movieId
        """)
    List<UserTicketDTO>findByMovieMovieId(Integer movieId);

    Optional<Ticket> findByTicketCode(String ticketCode);

    void deleteTicketByMovieMovieId(Integer movieId);
}
