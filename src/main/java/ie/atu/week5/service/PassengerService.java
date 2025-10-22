package ie.atu.week5.service;

import ie.atu.week5.errorhandling.DuplicateException;
import ie.atu.week5.model.Passenger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    private final List<Passenger> store = new ArrayList<>();

    public List<Passenger> findAll() {
        return new ArrayList<>(store);
    }

    public Optional<Passenger> findbyId(String id) {
        for (Passenger p : store) {
            if (p.getPassengerId().equals(id))
                return Optional.of(p);
        }
        return Optional.empty();
    }

    public Passenger create(Passenger p) {
        if (findbyId(p.getPassengerId()).isPresent()) {
            throw new DuplicateException("The passengerId of " + p.getPassengerId() + " already exists");
        }
        store.add(p);
        return p;
    }

    public Optional<Passenger> update(Passenger p) {
        Optional<Passenger> maybe = findbyId(p.getPassengerId());
        if(maybe.isPresent()) {
            Passenger update = maybe.get();
            update.setName(p.getName());
            update.setEmail(p.getEmail());
            return Optional.of(update);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Passenger> deletebyId(String id){
        for (Passenger p : store) {
            if (p.getPassengerId().equals(id)) {
                store.remove(p);
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }
}
