package com.keyin.domain.Aircraft;


import jakarta.persistence.*;
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
    private String status;




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

    private String getStatus () {
        return status;
    }

    public void setStatus(String status) {
        if (isValidStatus(status)) {
        this.status = status;
    } else {
        throw new IllegalArgumentException("Invalid status: " + status);
    }
    }

    private boolean isValidStatus(String status) {
    return status != null && (status.equals("ACTIVE") ||
            status.equals("DECOMMISSIONED") || status.equals("SOLD"));
}
}



