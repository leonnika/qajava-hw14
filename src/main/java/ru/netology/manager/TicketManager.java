package ru.netology.manager;

import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    public TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void remById(int id) {
        repository.removeById(id);
    }

    public void addTicket(TicketOffer ticket) {
        repository.save(ticket);
    }

    public TicketOffer[] findAllSort(String to, String from) {
        TicketOffer[] result = new TicketOffer[0];
        for (TicketOffer ticket : repository.findAll()) {
            if (matches(ticket, to, from)) {
                TicketOffer[] tmp = new TicketOffer[result.length + 1];
                // используйте System.arraycopy, чтобы скопировать всё из result в tmp
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(TicketOffer ticket, String searchTo, String searchFrom) {
        if ((ticket.getArrivalAirport().equalsIgnoreCase(searchTo)) && (ticket.getDepartureAirport().equalsIgnoreCase(searchFrom))) {
            return true;
        }
        return false;
    }

}
