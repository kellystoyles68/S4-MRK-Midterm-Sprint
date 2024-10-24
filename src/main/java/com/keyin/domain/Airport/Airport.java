package com.keyin.domain;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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

    @Repository
    public static interface AirportRepository extends JpaRepository<Airport, Long> {
        @Query("SELECT a.city.province, COUNT(a) FROM Airport a GROUP BY a.city.province HAVING COUNT(a) > 1")
        List<Object[]> findProvincesWithMultipleAirports();

    }

    @Repository
    public static interface CityRepository extends JpaRepository<City, Long> {
        @Query("SELECT c.province, SUM(c.population), COUNT(a) FROM City c LEFT JOIN c.airports a GROUP BY c.province HAVING SUM(c.population) BETWEEN 900000 AND 1100000")
        List<Object[]> findProvincesWithPopulationAndAirports();

        @Query("SELECT c.name, c.province, c.population, SUM(c2.population) as provincePopulation FROM City c JOIN City c2 ON c.province = c2.province WHERE EXISTS (SELECT 1 FROM Airport a WHERE a.city = c) GROUP BY c.name, c.province, c.population")
        List<Object[]> findCityProvincePopulationComparison();

    }
}
