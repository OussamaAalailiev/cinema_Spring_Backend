package org.siid.cinemamvcetangular.service;

/**This Interface is created in order to populate the DataBase with initial Data about App: */
public interface ICinemaDataInitializationService {
    public void initCities();
    public void initCinemas();
    public void initRooms();
    public void initPlaces();
    public void initFilmCategories();
    public void initFilms();
    public void initProjectionOfFilmInRoom();
    public void initFilmSessionsOfFilmProjection();
    public void initTickets();
}
