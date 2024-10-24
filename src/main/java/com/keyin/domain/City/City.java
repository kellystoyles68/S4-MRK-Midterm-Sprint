package com.keyin.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;
    private String name;
    private String city;
    private static String province;
    private int city_pop;
    private static int province_pop;

    @OneToMany(mappedBy = "cityId")
    private List<Airport> airports;

    public City( Long cityId, String name, String city, String province, int city_pop, int province_pop) {
        this.cityId = cityId;
        this.name = name;
        this.city = city;
        City.province = province;
        this.city_pop = city_pop;
        City.province_pop = province_pop;

}

    public static void province() {
    }

    public static void province_pop() {
    }

    public Long gecCityId() {
        return cityId;
    }

    public void setCityId(Long cityid) {
        this.cityId = cityid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        City.province = province;
    }

    public int getCity_pop() {
        return city_pop;
    }

    public void setCity_pop(int city_pop) {
        this.city_pop = city_pop;
    }

    public int getProvince_pop() {
        return province_pop;
    }

    public void setProvince_pop(int province_pop) {
        this.province_pop = province_pop;
    }
}

