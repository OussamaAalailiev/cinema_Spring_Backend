package org.siid.cinemamvcetangular.service;

import org.siid.cinemamvcetangular.entities.Ticket;
import org.siid.cinemamvcetangular.web.TicketFormSubmission;

import java.io.IOException;
import java.util.List;

public interface ICinemaService {

    public byte [] getImageFromLocalStorageByFilmID(Long id) throws IOException;
    public List<Ticket> ticketsPayment(TicketFormSubmission ticketFormSubmission);
}
