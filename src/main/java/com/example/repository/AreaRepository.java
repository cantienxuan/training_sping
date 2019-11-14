package com.example.repository;

import com.example.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AreaRepository extends JpaRepository<Area, Integer> {
    List<Area> findByPost_PostCode(String postCode);
}
