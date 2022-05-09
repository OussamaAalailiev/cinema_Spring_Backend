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
public class Film {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30)
    private String title;
    private Double duration;
    @Column(length = 30)
    private String producer;
    @Column(length = 200)
    private String description;
    private String picture;
    private Date releaseDate;
    @ManyToOne
    private CategoryFilm categoryFilm;
    @OneToMany(mappedBy = "film")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //'Access.WRITE_ONLY': means that serialize & get the 'projection..' field ONLY in case we want to add a new Film with an already existed 'projection..' field's data BUT NOT if we want to just get already existed Films(ex: Access.READ).
    private Collection<ProjectionOfFilmRoom> projectionOfFilmRoom;
}
