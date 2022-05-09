package org.siid.cinemamvcetangular.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;

@Projection(name = "projection1", types = {ProjectionOfFilmRoom.class})
public interface Projection1 {
    public Long getId();
    public Date getProjectionDate();
    public Double getPrice();
    public Room getRoom();
    public Film getFilm();
    public FilmSession getFilmSession();
    public Collection<Ticket> getTickets();
}
