package com.example.service.impl;

import com.example.model.City;
import com.example.repository.CityRepository;
import com.example.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> searchByPrefectureCodeResponse(String prefectureCode) {
        return cityRepository.findByPrefecture_PrefectureCode(prefectureCode);
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }
}
