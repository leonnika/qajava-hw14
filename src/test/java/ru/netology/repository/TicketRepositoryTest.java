package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketOffer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketRepositoryTest {
    private TicketRepository repository = new TicketRepository();
    private TicketOffer firstTicket = new TicketOffer(1, 10000, "LEG", "DME", 120);
    private TicketOffer secondTicket = new TicketOffer(2, 9000, "LEG", "KUF", 240);
    private TicketOffer thirdTicket = new TicketOffer(3, 11000, "LEG", "DME", 100);
    private TicketOffer fourthTicket = new TicketOffer(4, 10500, "DME", "LEG", 125);
    private TicketOffer fifthTicket = new TicketOffer(5, 10200, "KUF", "LEG", 220);
    private TicketOffer sixthTicket = new TicketOffer(6, 11200, "DME", "LEG", 110);
    private TicketOffer seventhTicket = new TicketOffer(7, 13000, "DME", "KUF", 210);
    private TicketOffer eighthTicket = new TicketOffer(8, 8000, "LEG", "DME", 140);
    private TicketOffer ninthTicket = new TicketOffer(9, 10900, "LEG", "KUF", 215);
    private TicketOffer tenthTicket = new TicketOffer(10, 10700, "KUF", "LEG", 230);
    private TicketOffer eleventhTicket = new TicketOffer(11, 12000, "DME", "LEG", 100);

    @BeforeEach
    void init() {
        repository.save(firstTicket);
        repository.save(secondTicket);
        repository.save(thirdTicket);
        repository.save(fourthTicket);
        repository.save(fifthTicket);
        repository.save(sixthTicket);
        repository.save(seventhTicket);
        repository.save(eighthTicket);
        repository.save(ninthTicket);
        repository.save(tenthTicket);
        repository.save(eleventhTicket);
    }

    @Test
    void ShouldRemoveByCorrectId() {
        repository.removeById(1);
        TicketOffer[] actual = repository.findAll();
        TicketOffer[] expected = new TicketOffer[]{secondTicket, thirdTicket, fourthTicket, fifthTicket, sixthTicket, seventhTicket, eighthTicket, ninthTicket, tenthTicket, eleventhTicket};
        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldRemoveByNotCorrectId() {
        repository.removeById(100);
        TicketOffer[] actual = repository.findAll();
        TicketOffer[] expected = new TicketOffer[]{firstTicket, secondTicket, thirdTicket, fourthTicket, fifthTicket, sixthTicket, seventhTicket, eighthTicket, ninthTicket, tenthTicket, eleventhTicket};
        assertArrayEquals(expected, actual);
    }
}