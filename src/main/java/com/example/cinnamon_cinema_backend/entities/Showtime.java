package com.example.cinnamon_cinema_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Showtime {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String startTime;
    private String endTime;
    private String date;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToMany(mappedBy = "showtime")
    private Set<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
