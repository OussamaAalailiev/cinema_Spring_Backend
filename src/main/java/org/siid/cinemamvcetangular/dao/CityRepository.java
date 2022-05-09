package org.siid.cinemamvcetangular.dao;

import org.siid.cinemamvcetangular.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**-'@RepositoryRestResource': This gives us a defaults Rest API (defaults endpoints using the specified
 *   entity 'City' & 'GET requests'), ex: "localhost:8082/cities/...".
 *   -It also uses all the methods inherited from "JpaRepository<City, Long>"*/
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")//Means that only pages
// from this Website are allowed to request resources from This App(Backend), it could be integrated by Spring Security.
public interface CityRepository extends JpaRepository<City, Long> {
}
