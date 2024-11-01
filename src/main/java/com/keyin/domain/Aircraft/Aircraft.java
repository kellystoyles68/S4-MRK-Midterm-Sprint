package com.keyin.domain.Aircraft;

import com.keyin.domain.Airport.Airport;
import com.keyin.domain.Passenger.Passenger;
import jakarta.persistence.*;
import java.util.List;
import java.time.LocalDate;

@Entity
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aircraftId;
    private String airline;
    private String model;
    private int capacity;
    private LocalDate lastServiceDate;

    @ManyToMany(mappedBy = "aircraft")
    private List<Passenger> passengers;

    @ManyToMany(mappedBy = "aircraft")
    private List<Airport> airports;


    public Aircraft() {
    }

    @Enumerated(EnumType.STRING)
    private AircraftStatus status;

    public enum AircraftStatus {
        ACTIVE, DECOMMISSIONED, SOLD
    }

    public Long getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(Long aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDate getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(LocalDate lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    private  AircraftStatus getStatus () {
        return status;
    }

    public void setStatus(AircraftStatus status) {
        this.status = status;
    }

    public Aircraft(Long aircraftId, String airline, String model, int capacity,  LocalDate lastServiceDate, AircraftStatus status ) {
        this.aircraftId = aircraftId;
        this.airline = airline;
        this.model = model;
        this.capacity = capacity;
        this.lastServiceDate = lastServiceDate;
        this.status = status;
    }

}

