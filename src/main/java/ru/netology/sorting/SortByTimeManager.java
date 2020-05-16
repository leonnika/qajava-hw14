package ru.netology.sorting;

import ru.netology.domain.TicketOffer;

import java.util.Comparator;


public class SortByTimeManager implements Comparator<TicketOffer> {
    public int compare(TicketOffer t1, TicketOffer t2) {
        return t1.getTimeTravel() - t2.getTimeTravel();
    }
}
