package ru.netology.sorting;

import ru.netology.domain.TicketOffer;

import java.util.Comparator;

public class SortByPriceManager implements Comparator<TicketOffer> {
    public int compare(TicketOffer t1, TicketOffer t2) {
        return t1.getTicketPrice() - t2.getTicketPrice();
    }
}