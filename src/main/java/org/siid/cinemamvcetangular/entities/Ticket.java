package org.siid.cinemamvcetangular.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity @NoArgsConstructor @AllArgsConstructor @Data
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30)
    private String clientName;
    private Double ticketPrice;
    private Integer paymentCode;//AccountNumber of the client
    private Boolean reserved;
    @ManyToOne
    private Place place;
    @ManyToOne
    private ProjectionOfFilmRoom projectionOfFilmRoom;

}
