package org.siid.cinemamvcetangular.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity @NoArgsConstructor @AllArgsConstructor @Data
public class Room {//Salle
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String name;
    private Integer placeNumbers;//nombrePlaces
    @ManyToOne @JoinColumn(columnDefinition = "id_cinema")//ForeignKey that references cinema's Id.
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//Just Added on 29/04/2022 to resolve 'StackOverFlowError' on a Json Response.
    private Cinema cinema;
    @OneToMany(mappedBy = "room")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Place> places;
    @OneToMany(mappedBy = "room")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<ProjectionOfFilmRoom> projectionOfFilmRooms;
}
