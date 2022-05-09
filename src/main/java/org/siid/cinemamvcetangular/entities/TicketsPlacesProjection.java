package org.siid.cinemamvcetangular.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "TicketsProjection", types = Ticket.class)
public interface TicketsPlacesProjection {
    public Long getId();
    public String getClientName();
    public Double getTicketPrice();
    public Integer getPaymentCode();
    public Boolean getReserved();
    public Place getPlace();
}
