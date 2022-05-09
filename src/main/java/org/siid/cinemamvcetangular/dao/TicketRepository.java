package org.siid.cinemamvcetangular.dao;

import org.siid.cinemamvcetangular.entities.Place;
import org.siid.cinemamvcetangular.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**'@RepositoryRestResource': This gives us a defaults Rest API (defaults endpoints using the specified
 *   entity 'Ticket' & 'GET requests'), ex: "localhost:8082/tickets/..."+ */
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
