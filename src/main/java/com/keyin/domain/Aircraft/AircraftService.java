package com.keyin.domain.Aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {

    private final AircraftRepository aircraftRepository;

    @Autowired
    public AircraftService(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    public List<Aircraft> getAllAircrafts() {
        return aircraftRepository.findAll();
    }

    public Optional<Aircraft> getAircraftById(Long id) {
        return aircraftRepository.findById(id);
    }

    public Aircraft addAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    public void deleteAircraft(Long id) {
        aircraftRepository.deleteById(id);
    }

    public Aircraft updateAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    public LocalDate NextServiceDate(Aircraft aircraft) {
        if (aircraft.getLastServiceDate() == null) {
            return LocalDate.now().plusDays(30);
        } else {
            return aircraft.getLastServiceDate().plusDays(30);
        }
    }

    public void updateLastServiceDate(long aircraftId, LocalDate serviceDate) {
        Optional<Aircraft> optionalAircraft = aircraftRepository.findById(aircraftId);
        if (optionalAircraft.isPresent()) {
            Aircraft aircraft = optionalAircraft.get();
            aircraft.setLastServiceDate(serviceDate);
            aircraftRepository.save(aircraft);
        }
    }
}