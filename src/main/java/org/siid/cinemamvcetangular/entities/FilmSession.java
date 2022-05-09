package org.siid.cinemamvcetangular.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity @NoArgsConstructor @AllArgsConstructor @Data
public class FilmSession {//Seance class
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIME)
    private Date hourDebut; //heureDebut
}
