package org.siid.cinemamvcetangular.dao;

import org.siid.cinemamvcetangular.entities.Film;
import org.siid.cinemamvcetangular.entities.FilmSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**'@RepositoryRestResource': This gives us a defaults Rest API (defaults endpoints using the specified
 *   entity 'FilmSession' & 'GET requests'), ex: "localhost:8082/filmSessions/..."+ */
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface FilmSessionRepository extends JpaRepository<FilmSession, Long> {
}
