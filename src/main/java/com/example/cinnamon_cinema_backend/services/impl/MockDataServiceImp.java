package com.example.cinnamon_cinema_backend.services.impl;

import com.example.cinnamon_cinema_backend.dtos.Seat;
import com.example.cinnamon_cinema_backend.entities.*;
import com.example.cinnamon_cinema_backend.repositories.*;
import com.example.cinnamon_cinema_backend.services.MockDataService;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class MockDataServiceImp implements MockDataService {
    private final CinemaRepo cinemaRepo;
    private final MovieRepo movieRepo;
    private final GenreRepo genreRepo;
    private final MovieImageRepo movieImageRepo;
    private final RoleRepo roleRepo;
    private final RoomRepo roomRepo;
    private final SeatRepo seatRepo;
    private final ShowtimeRepo showtimeRepo;
    private final TicketRepo ticketRepo;
    private final TicketSeatRepo ticketSeatRepo;
    private final TransactionRepo transactionRepo;
    private final UserRepo userRepo;

    private final Faker faker = new Faker();
    private final int NUMBER_OF_CINEMAS = 5;
    private final int NUMBER_OF_ROOMS = 5;
    private final int NUMBER_OF_SEATS = 70;
    private final int NUMBER_OF_TICKETS = 20;
    private final int NUMBER_OF_USERS = 20;
    private final int NUMBER_OF_MOVIES = 20;
    private final int NUMBER_OF_GENRES = 10;
    private final int NUMBER_OF_SHOWTIMES = 30;
    private final int NUMBER_OF_TICKET_SEATS = 50;
    private final int NUMBER_OF_TRANSACTIONS =50;
    private final int NUMBER_OF_ROLES = 3;
    private final int NUMBER_OF_MOVIE_IMAGES = 50;

    @Override
    public void mockData() {

        if (cinemaRepo.count() == 0){
            for (int i = 0; i< NUMBER_OF_CINEMAS; i++){
                Cinema cinema = new Cinema();
                cinema.setName(faker.company().name());
                cinema.setAddress(faker.address().fullAddress());
                cinemaRepo.save(cinema);
            }
        }

        if(genreRepo.count() == 0){
            for (int i = 0; i< NUMBER_OF_GENRES; i++){
                Genre genre = new Genre();
                genre.setName(faker.book().genre());
                genreRepo.save(genre);
            }
        }
        if (roleRepo.count() == 0){
            for (int i = 0; i< NUMBER_OF_ROLES; i++){
                Role role = new Role();
                role.setName(faker.job().title());
                roleRepo.save(role);
            }
        }
        if (roomRepo.count() == 0){
            for (int i = 0; i< NUMBER_OF_ROOMS; i++){
                Room room = new Room();
                room.setName(faker.lorem().word());
                room.setCinema(cinemaRepo.findById((long) faker.number().numberBetween(1, NUMBER_OF_CINEMAS)).orElse(null));
                roomRepo.save(room);
            }
        }
        if (seatRepo.count() == 0){
            for (int i = 0; i < NUMBER_OF_SEATS; i++){
                Seat seat = new Seat();
                seat.setSeatNumber(String.valueOf(i % 10));
                seat.setRoom(roomRepo.findById((long) faker.number().numberBetween(1, NUMBER_OF_ROOMS)).orElse(null));
                seat.setAvailable(true);
                seatRepo.save(seat);
            }
        }



        if(movieRepo.count() == 0){
            for (int i = 0; i< NUMBER_OF_MOVIES; i++){
                Movie movie = new Movie();
                movie.setTitle(faker.book().title());
                movie.setDescription(faker.lorem().paragraph());
                movie.setDuration(String.valueOf(faker.number().numberBetween(60, 180)));
                movie.setReleaseDate(String.valueOf(faker.date().past(365, TimeUnit.DAYS)));
                movieRepo.save(movie);
            }
        }
        if (showtimeRepo.count() == 0){
            for (int i = 0; i< NUMBER_OF_SHOWTIMES; i++){
                Showtime showtime = new Showtime();
                showtime.setMovie(movieRepo.findById((long) faker.number().numberBetween(1, NUMBER_OF_MOVIES)).orElse(null));
                showtime.setRoom(roomRepo.findById((long) faker.number().numberBetween(1, NUMBER_OF_ROOMS)).orElse(null));
                showtime.setStartTime(String.valueOf(faker.date().future(30, TimeUnit.DAYS)));
                showtime.setEndTime(String.valueOf(faker.date().future(30, TimeUnit.DAYS)));
                showtimeRepo.save(showtime);
            }
        }
        if (userRepo.count() == 0){
            for (int i = 0; i< NUMBER_OF_USERS; i++){
                User user = new User();
                user.setUsername(faker.name().username());
                user.setPassword(faker.internet().password());
                user.setEmail(faker.internet().emailAddress());

                user.setRole(roleRepo.findById((long) faker.number().numberBetween(1, NUMBER_OF_ROLES)).orElse(null));
                userRepo.save(user);
            }
        }
    }

    @Override
    public void clearData() {

        ticketSeatRepo.deleteAll();
        ticketRepo.deleteAll();
        transactionRepo.deleteAll();
        showtimeRepo.deleteAll();
        seatRepo.deleteAll();
        roomRepo.deleteAll();
        movieImageRepo.deleteAll();
        genreRepo.deleteAll();
        movieRepo.deleteAll();
        userRepo.deleteAll();
        roleRepo.deleteAll();
        cinemaRepo.deleteAll();

        log.info("Mock data cleared");
    }
}
