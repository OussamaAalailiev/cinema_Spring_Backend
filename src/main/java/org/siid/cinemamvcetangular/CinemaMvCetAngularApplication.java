package org.siid.cinemamvcetangular;

import org.siid.cinemamvcetangular.entities.Film;
import org.siid.cinemamvcetangular.entities.Room;
import org.siid.cinemamvcetangular.entities.Ticket;
import org.siid.cinemamvcetangular.service.ICinemaDataInitializationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CinemaMvCetAngularApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaMvCetAngularApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ICinemaDataInitializationService iCinemaDataInitializationService,
                            RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Film.class, Room.class, Ticket.class);//To integrate Film's ID & Room's ID in each Json Response to a Client.
            iCinemaDataInitializationService.initCities();
            iCinemaDataInitializationService.initCinemas();
            iCinemaDataInitializationService.initRooms();
            iCinemaDataInitializationService.initPlaces();
            iCinemaDataInitializationService.initFilmCategories();
            iCinemaDataInitializationService.initFilms();
            iCinemaDataInitializationService.initFilmSessionsOfFilmProjection();
            iCinemaDataInitializationService.initProjectionOfFilmInRoom();
            iCinemaDataInitializationService.initTickets();
        };
    }

}
