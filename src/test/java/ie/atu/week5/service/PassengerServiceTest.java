package ie.atu.week5.service;

import ie.atu.week5.model.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerServiceTest {

    private PassengerService service;

    @BeforeEach
    void setup(){
        service = new PassengerService();
    }

    @Test
    void createThenFindById() {
        Passenger p = new Passenger("1", "Lance", "Lance@atu.ie");

        service.create(p);

        Optional<Passenger> found = service.findbyId("1");
        assertTrue(found.isPresent());
        assertEquals("Lance", found.get().getName());
    }

    @Test
    void duplicateIdThrows() {
        service.create(new Passenger("2", "Bob", "b@atu.ie"));

        assertThrows(IllegalArgumentException.class, () ->
                service.create(new Passenger("2", "Bobby", "bob@atu.ie")));
    }

}
