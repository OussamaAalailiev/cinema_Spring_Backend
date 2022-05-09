package org.siid.cinemamvcetangular.service;

import org.siid.cinemamvcetangular.dao.FilmRepository;
import org.siid.cinemamvcetangular.dao.TicketRepository;
import org.siid.cinemamvcetangular.entities.Film;
import org.siid.cinemamvcetangular.entities.Ticket;
import org.siid.cinemamvcetangular.web.TicketFormSubmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class CinemaServiceImpl implements ICinemaService {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public byte[] getImageFromLocalStorageByFilmID(Long id) throws IOException {
        Film film = filmRepository.getById(id);
        String imageName = film.getPicture();
        //'System.getProperty("user.home")': To get the File of the User's Operating System of the Server.
        File file = new File(System.getProperty("user.home")+"/cinemaPictures/images/"+imageName+".jpg");
        System.out.println("*************************");
        System.out.println("File: " + file);
        System.out.println("System.getProperty('user.home'): " + System.getProperty("user.home"));
        Path path = Paths.get(file.toURI());
        System.out.println("Path: " + path);
        System.out.println("*********************");
        System.out.println("Image Bytes= " + Files.readAllBytes(path));
        return Files.readAllBytes(path);
    }

    @Override//Null Exceptions & Other Errors aren't implemented yet down below:
    public List<Ticket> ticketsPayment(TicketFormSubmission ticketFormSubmission) {
        List<Ticket> ticketsSubmittedByUser = new ArrayList<>();
        ticketFormSubmission.getTickets().forEach(ticketID->{
            Ticket ticket = ticketRepository.findById(ticketID).get();
            ticket.setClientName(ticketFormSubmission.getClientName());
            ticket.setReserved(true);
            ticket.setPaymentCode(ticketFormSubmission.getPaymentCode());
            ticketRepository.save(ticket);
            ticketsSubmittedByUser.add(ticket);
        });
        return ticketsSubmittedByUser;
    }
}
