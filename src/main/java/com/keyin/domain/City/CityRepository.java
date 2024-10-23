package com.keyin.domain;

import com.keyin.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    @Query("SELECT c.province, SUM(c.population), COUNT(a) FROM City c LEFT JOIN c.airports a GROUP BY c.province HAVING SUM(c.population) BETWEEN 900000 AND 1100000")
    List<Object[]> findProvincesWithPopulationAndAirports();

    @Query("SELECT c.name, c.province, c.population, SUM(c2.population) as provincePopulation FROM City c JOIN City c2 ON c.province = c2.province WHERE EXISTS (SELECT 1 FROM Airport a WHERE a.city = c) GROUP BY c.name, c.province, c.population")
    List<Object[]> findCityProvincePopulationComparison();
}