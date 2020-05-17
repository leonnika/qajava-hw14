package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketOffer implements Comparable<TicketOffer> {
    private int id;
    private int ticketPrice;
    private String arrivalAirport;
    private String departureAirport;
    private int timeTravel;

    @Override
    public int compareTo(TicketOffer t) {
        return ticketPrice - t.ticketPrice;
    }
}
