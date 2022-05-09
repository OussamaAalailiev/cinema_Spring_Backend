package org.siid.cinemamvcetangular.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity @NoArgsConstructor @AllArgsConstructor @Data
public class City {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 35)
    private String name;
    private Double longitude;
    private Double latitude;
    private Double altitude;
    @OneToMany(mappedBy = "city") /** mappedBy="...": means that the relation between "Cinema" & "City" is Bidirectional. */
    Collection<Cinema> cinemas;
}
