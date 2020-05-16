package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    private TicketOffer fistTicket = new TicketOffer(1, 10000, "LEG", "DME", 120);
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
        manager.addTicket(fistTicket);
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
    void shouldfindAllSort() {
        TicketOffer[] actual = manager.findAllSort("LEG", "DME");
        TicketOffer[] expected = new TicketOffer[]{eighthTicket, fistTicket, thirdTicket};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldfindAllSortEmpty() {
        TicketOffer[] actual = manager.findAllSort("LEG", "LEG");
        TicketOffer[] expected = new TicketOffer[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldfindAllSortAfteRemove() {
        manager.remById(1);
        TicketOffer[] actual = manager.findAllSort("LEG", "DME");
        TicketOffer[] expected = new TicketOffer[]{eighthTicket, thirdTicket};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldfindAllSortAfteRemoveNoCorrect() {
        manager.remById(1000);
        TicketOffer[] actual = manager.findAllSort("LEG", "DME");
        TicketOffer[] expected = new TicketOffer[]{eighthTicket, fistTicket, thirdTicket};
        assertArrayEquals(expected, actual);
    }
}