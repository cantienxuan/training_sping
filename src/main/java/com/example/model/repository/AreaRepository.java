package com.example.model.repository;

import com.example.model.Entities.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AreaRepository extends JpaRepository<Area, Integer> {
	/**
	 * find Area by postCode
	 * @param postCode code of post input
	 * @return Area List corresponding with postCode
	 */
	List<Area> findByPost_PostCode(String postCode);
}
