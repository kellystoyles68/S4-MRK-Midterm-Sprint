package com.keyin.domain.Aircraft;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aircraft")
public class AircraftController {

    private final AircraftService aircraftService;

    @Autowired
    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping
    public List<Aircraft> getAllAircraft() {
        return aircraftService.getAllAircrafts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aircraft> getAircraftById(@PathVariable Long id) {
        return aircraftService.getAircraftById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Aircraft addAircraft(@RequestBody Aircraft aircraft) {
        return aircraftService.addAircraft(aircraft);
    }

    @DeleteMapping("/api/aircraft/{id}")
    public ResponseEntity<Void> deleteAircraft(@PathVariable Long id) {
        Optional<Aircraft> aircraft = aircraftService.getAircraftById(id);
        if (aircraft.isPresent()) {
            aircraftService.deleteAircraft(id);
            return ResponseEntity.noContent().build();  // 204 No Content for successful deletion
        } else {
            return ResponseEntity.notFound().build();  // 404 Not Found if the aircraft doesn't exist
        }
    }

}