package org.siid.cinemamvcetangular.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity @NoArgsConstructor @AllArgsConstructor @Data
public class ProjectionOfFilmRoom {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date projectionDate;
    private Double price;
    @ManyToOne
    private Film film;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Room room;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "projectionOfFilmRoom")
    private Collection<Ticket> tickets;
    @ManyToOne /**There is No 'mappedBy=""' because the relationship between both entities 'Projection..' &
                   'FilmSession' is UNIDIRECTIONAL(meaning the 'Projection..' entity knows about 'FilmSession'
                    but 'FilmSession' entity does Not know about 'Projection..').*/
    //Couldn't understand yet this '@ManyToOne'
    // relationship to 'filmSession', Entity 'ProjectionOfFilmRoom' could be replaced by 'FilmSession(Seance)'.
    private FilmSession filmSession;//Seance //(Normally ProjectionOfFilmInRoom could be replaced with FilmSession)
}
