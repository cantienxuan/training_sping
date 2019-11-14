package com.example.repository;

import com.example.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByPrefecture_PrefectureCode(String postCode);
    List<City> findAll();
}
