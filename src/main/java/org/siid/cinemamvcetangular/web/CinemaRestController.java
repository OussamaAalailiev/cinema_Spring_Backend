package org.siid.cinemamvcetangular.web;

import org.siid.cinemamvcetangular.dao.FilmRepository;
import org.siid.cinemamvcetangular.dao.TicketRepository;
import org.siid.cinemamvcetangular.entities.Film;
import org.siid.cinemamvcetangular.entities.Ticket;
import org.siid.cinemamvcetangular.service.ICinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("http://localhost:4200")//Means that only pages from this Website are allowed to request resources from This App(Backend).
@RestController
public class CinemaRestController {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ICinemaService iCinemaService;

    /**To get pictures stored inside the Operating System's Folder
     *  to the App that were stored by the user THROUGH Rest API: */

    @GetMapping(path = "/filmImage/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    //'produces = MediaType.IMAGE_JPEG_VALUE': we tell the Browser that when u receive this Array []
    //  of bytes we need this bytes to be transformed to Image of Type JPEG.
    //We get the Picture by Film's ID & Picture's name + File's URI of the Server's OS:
    public byte[] getImageInBinaryFormByID(@PathVariable(name = "id") Long id) throws IOException {
        return iCinemaService.getImageFromLocalStorageByFilmID(id);
    }

//    public byte[] getImageInBinaryFormByID(@PathVariable(name = "id") Long id) throws IOException {
//        Film film = filmRepository.getById(id);
//        String imageName = film.getPicture();
//        //'System.getProperty("user.home")': To get the File of the User's Operating System of the Server.
//        File file = new File(System.getProperty("user.home")+"/cinemaPictures/images/"+imageName+".jpg");
//        System.out.println("*************************");
//        System.out.println("File: " + file);
//        System.out.println("System.getProperty('user.home'): " + System.getProperty("user.home"));
//        Path path = Paths.get(file.toURI());
//        System.out.println("Path: " + path);
//        System.out.println("*********************");
//        System.out.println("Image Bytes= " + Files.readAllBytes(path));
//        return Files.readAllBytes(path);
//    }

    //A Method for Tickets Payments: info sent by user while submitting the ticket(s) form inside
    //   the body of the request in Json format:

    @PostMapping(path = "/payTickets")
    public List<Ticket> getTicketsPaid(@RequestBody TicketFormSubmission ticketFormSubmission){
        return iCinemaService.ticketsPayment(ticketFormSubmission);
    }

//    @PostMapping(path = "/payTickets")
//    @Transactional //added but not tested here.
//    public List<Ticket> ticketsPayment(@RequestBody TicketFormSubmission ticketFormSubmission){
//        List<Ticket> ticketsSubmittedByUser = new ArrayList<>();
//        ticketFormSubmission.getTicketsIDsChosenByUser().forEach(ticketID->{
//            Ticket ticket = ticketRepository.findById(ticketID).get();
//            ticket.setClientName(ticketFormSubmission.getClientNameForm());
//            ticket.setReserved(true);
//            ticket.setPaymentCode(ticketFormSubmission.getPaymentCode());
//            ticketRepository.save(ticket);
//            ticketsSubmittedByUser.add(ticket);
//        });
//        return ticketsSubmittedByUser;
//    }

    @GetMapping(path = "/getAllFilms")
    public List<Film> getListFilms(){
        return filmRepository.findAll();
    }



}
