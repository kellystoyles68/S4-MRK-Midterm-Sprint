package com.keyin.domain.Airport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.keyin.domain.Aircraft.Aircraft;
import com.keyin.domain.City.City;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airportId;

    private String name;
    private String IATA_code;

    @ManyToOne
    @JoinColumn(name = "cityId", nullable = false) // Set nullable as per your business logic
    @JsonIgnore // Prevent recursive serialization

    private City city;

    @ManyToMany(cascade = CascadeType.ALL) // Adjust as necessary
    @JoinTable(
            name = "airport_aircraft",
            joinColumns = @JoinColumn(name = "airport_id"),
            inverseJoinColumns = @JoinColumn(name = "aircraft_id")
    )
    private List<Aircraft> aircraft = new ArrayList<>(); // Initialize to avoid NullPointerException

    // Constructors
    public Airport() {
    }

    public Airport(String name, String IATA_code, City city) {
        this.name = name;
        this.IATA_code = IATA_code;
        this.city = city;
    }

    // Getters and Setters
    public Long getAirportId() {
        return airportId;
    }

    public void setAirportId(Long airportId) {
        this.airportId = airportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIATA_code() {
        return IATA_code;
    }

    public void setIATA_code(String IATA_code) {
        this.IATA_code = IATA_code;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Aircraft> getAircraft() {
        return aircraft;
    }

    public void setAircraft(List<Aircraft> aircraft) {
        this.aircraft = aircraft;
    }
}
