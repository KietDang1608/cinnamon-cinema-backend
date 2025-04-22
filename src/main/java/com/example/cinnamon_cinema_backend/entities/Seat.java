package com.example.cinnamon_cinema_backend.dtos;

import com.example.cinnamon_cinema_backend.entities.Room;
import com.example.cinnamon_cinema_backend.entities.TicketSeat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
public class Seat {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String seatNumber;
    private boolean available;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(mappedBy = "seat")
    private Set<TicketSeat> ticketSeats;


}
