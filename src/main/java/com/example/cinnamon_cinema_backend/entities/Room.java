package com.example.cinnamon_cinema_backend.entities;

import com.example.cinnamon_cinema_backend.dtos.Seat;
import com.example.cinnamon_cinema_backend.dtos.SeatDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "room")
    private Set<Seat> seats;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    @OneToMany(mappedBy = "room")
    private Set<Showtime> showtimes;
}
