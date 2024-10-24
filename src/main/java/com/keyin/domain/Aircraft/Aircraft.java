package com.keyin.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static long aircraftId;
    private static String airline;
    private static String model;
    private static int capacity;

    @ManyToMany(mappedBy = "aircraftId")
    private List<Passenger> passengers;

    @ManyToMany(mappedBy = "aircraftId")
    private List<Airport> airports;


    public Aircraft(long aircraftId, String airline, String model, int capacity) {
        Aircraft.aircraftId = aircraftId;
        Aircraft.airline = airline;
        Aircraft.model = model;
        Aircraft.capacity = capacity;
    }



    public static void airline() {
    }

    public static void  model() {

    }

    public static void capacity() {

    }


   /* public long getaircraftId() {
        return aircraftId;
    }

    public void setaircraftId(long aircraftId) {
        Aircraft.aircraftId = aircraftId;
    }*/

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        Aircraft.airline = airline;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        Aircraft.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        Aircraft.capacity = capacity;
    }
}
