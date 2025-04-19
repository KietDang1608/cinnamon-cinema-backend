package com.example.cinnamon_cinema_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)

    private Long id;
    private String title;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;
    private String duration;

    private String releaseDate;

    @OneToMany(mappedBy = "movie")
    private Set<MovieImage> images;
    
    @OneToMany(mappedBy = "movie")
    private Set<Showtime> showtimes;

}
