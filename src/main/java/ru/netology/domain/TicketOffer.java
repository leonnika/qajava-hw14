package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketOffer implements Comparable<TicketOffer> {
    private int id;
    private int TicketPrice;
    private String ArrivalAirport;
    private String DepartureAirport;
    private int TimeTravel;

    @Override
    public int compareTo(TicketOffer t) {
        return TicketPrice - t.TicketPrice;
    }
}
