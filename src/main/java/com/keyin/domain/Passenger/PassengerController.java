package com.keyin.domain.Passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passenger")
public class PassengerController {

    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

   // @GetMapping
   // public List<Passenger> getAllPassenger() {
   //     return passengerService.getAllPassenger();
   // }

  //  @GetMapping("/{id}")
   // public ResponseEntity<Passenger> getAircraftById(@PathVariable //Long id) {
    //    return passengerService.getPassengerById(id)
    //            .map(ResponseEntity::ok)
    //            .orElse(ResponseEntity.notFound().build());
   // }

    @GetMapping("/count/{airportCode}")
    public ResponseEntity<Long> getPassengerCountForAirport(@PathVariable String airportCode) {
        Long count = passengerService.getPassengerCountForAirport(airportCode);
        return ResponseEntity.ok(count);
    }

    @PostMapping
    public Passenger addPassenger(@RequestBody Passenger passenger) {
        return passengerService.addPassenger(passenger);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
        return ResponseEntity.noContent().build();
    }
}