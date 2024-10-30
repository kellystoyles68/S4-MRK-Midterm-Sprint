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
    private boolean active;

    @ManyToMany(mappedBy = "aircraft")
    private List<Passenger> passengers;

    @ManyToMany(mappedBy = "aircraft")
    private List<Airport> airports;


    public Aircraft() {
    }

    public Aircraft(Long aircraftId, String airline, String model, int capacity,  LocalDate lastServiceDate, boolean active) {
        this.aircraftId = aircraftId;
        this.airline = airline;
        this.model = model;
        this.capacity = capacity;
        this.lastServiceDate = LocalDate.now();
        this.active = true;
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

    private boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

