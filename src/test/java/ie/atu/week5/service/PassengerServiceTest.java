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

    @Test
    void updatePassenger() {
        Passenger p = new Passenger("3", "Lance", "Lance@atu.ie");

        service.create(p);

        Passenger updated = new Passenger("3", "newLance", "newLance@atu.ie");
        Optional<Passenger> updatedPassenger = service.update(updated);

        assertTrue(updatedPassenger.isPresent());
        assertEquals("newLance", updatedPassenger.get().getName());
        assertEquals("newLance@atu.ie", updatedPassenger.get().getEmail());
    }

    @Test
    void deletePassengerId() {
        Passenger p = new Passenger("3", "Lance", "Lance@atu.ie");

        service.create(p);

        Optional<Passenger> deletePassenger = service.deletebyId("3");

        assertTrue(deletePassenger.isPresent());
        assertEquals("Lance", deletePassenger.get().getName());
        assertEquals("Lance@atu.ie", deletePassenger.get().getEmail());
    }

}
