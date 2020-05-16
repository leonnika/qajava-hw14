package ru.netology.repository;

import ru.netology.domain.TicketOffer;

public class TicketRepository {


    private TicketOffer[] ticket = new TicketOffer[0];

    public void save(TicketOffer item) {
        int length = ticket.length + 1;
        TicketOffer[] tmp = new TicketOffer[length];
        System.arraycopy(ticket, 0, tmp, 0, ticket.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        ticket = tmp;
    }

    public TicketOffer[] findAll() {
        return ticket;
    }

    public void removeById(int id) {
        int length = ticket.length - 1;
        TicketOffer[] tmp = new TicketOffer[length];
        int countInput = 0;
        for (TicketOffer item : ticket) {
            if (item.getId() != id) {
                countInput++;
            }
        }
        if (countInput == length) {
            int index = 0;
            for (TicketOffer item : ticket) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            } // меняем наши элементы items = tmp;
            ticket = tmp;
        }
    }
}


