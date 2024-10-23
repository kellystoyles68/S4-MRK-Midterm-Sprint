package com.keyin.domain.Airport;

import com.keyin.domain.Aircraft.Aircraft;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airportId;
    private String name;
    private static String IATA_code;

    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;

    @ManyToMany
    private List<Aircraft> aircraft;



    public Airport(Long airportId, String name, String IATA_code) {
        this.airportId = airportId;
        this.name = name;
        this.IATA_code = IATA_code;
    }

    public static void IATA_code() {
    }

    public long getAirportId() {
        return airportId;
    }

    public void setAirportId(long airportId) {
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
}