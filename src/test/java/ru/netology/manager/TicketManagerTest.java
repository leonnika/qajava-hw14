package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketRepository;
import ru.netology.sorting.SortByTimeManager;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);
    private Comparator<TicketOffer> comparator = new SortByTimeManager();
    private TicketOffer firstTicket = new TicketOffer(1, 10000, "LEG", "DME", 120);
    private TicketOffer secondTicket = new TicketOffer(2, 9000, "LEG", "KUF", 240);
    private TicketOffer thirdTicket = new TicketOffer(3, 11000, "LEG", "DME", 100);
    private TicketOffer fourthTicket = new TicketOffer(4, 10500, "DME", "LEG", 125);
    private TicketOffer fifthTicket = new TicketOffer(5, 10200, "KUF", "LEG", 220);
    private TicketOffer sixthTicket = new TicketOffer(6, 10200, "KUF", "LEG", 110);
    private TicketOffer seventhTicket = new TicketOffer(7, 13000, "DME", "KUF", 210);
    private TicketOffer eighthTicket = new TicketOffer(8, 8000, "LEG", "DME", 140);
    private TicketOffer ninthTicket = new TicketOffer(9, 10900, "LEG", "KUF", 215);
    private TicketOffer tenthTicket = new TicketOffer(10, 10700, "KUF", "LEG", 230);
    private TicketOffer eleventhTicket = new TicketOffer(11, 10700, "KUF", "LEG", 100);

    @BeforeEach
    void init() {
        manager.addTicket(firstTicket);
        manager.addTicket(secondTicket);
        manager.addTicket(thirdTicket);
        manager.addTicket(fourthTicket);
        manager.addTicket(fifthTicket);
        manager.addTicket(sixthTicket);
        manager.addTicket(seventhTicket);
        manager.addTicket(eighthTicket);
        manager.addTicket(ninthTicket);
        manager.addTicket(tenthTicket);
        manager.addTicket(eleventhTicket);
    }

    @Test
    void shouldFindAllSort() {
        TicketOffer[] actual = manager.findAllSort("LEG", "DME");
        TicketOffer[] expected = new TicketOffer[]{eighthTicket, firstTicket, thirdTicket};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllSortEmpty() {
        TicketOffer[] actual = manager.findAllSort("LEG", "LEG");
        TicketOffer[] expected = new TicketOffer[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldfindAllSortPriceAndTime() {
        TicketOffer[] actual = manager.findAllSortComparator("KUF", "LEG", comparator);
        TicketOffer[] expected = new TicketOffer[]{sixthTicket, fifthTicket, eleventhTicket, tenthTicket};
        assertArrayEquals(expected, actual);
    }
}