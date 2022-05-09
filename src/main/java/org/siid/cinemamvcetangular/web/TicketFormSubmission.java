package org.siid.cinemamvcetangular.web;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**Class created to represent the data sent by user in Json Format While submitting a form(that
 *   contains 1-client's name, 2-List Of Tickets IDs AND 3-paymentCode (account Number). : */
@Data
public class TicketFormSubmission {
    private List<Long> tickets = new ArrayList<>();
    private String clientName;
    private Integer paymentCode;
}
