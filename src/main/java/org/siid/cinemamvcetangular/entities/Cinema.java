package org.siid.cinemamvcetangular.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity @NoArgsConstructor @AllArgsConstructor @Data
public class Cinema {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 25)
    private String name;
    private Double longitude;
    private Double latitude;
    private Double altitude;
    private Integer roomNumbers;//nombreSalles
    @ManyToOne
    private City city;
    @OneToMany(mappedBy = "cinema")
    private Collection<Room> rooms;
}
