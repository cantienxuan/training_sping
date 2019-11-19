package com.example.model.repository;

import com.example.model.Entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

	/**
	 * find cities by prefectureCode
	 * @param prefectureCode code of prefecture
	 * @return city list corresponding with prefectureCode
	 */
	List<City> findByPrefecture_PrefectureCode(String prefectureCode);
}
