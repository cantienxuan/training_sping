package com.example.service.impl;

import com.example.model.Area;
import com.example.model.Prefecture;
import com.example.repository.AreaRepository;
import com.example.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<Area> searchByPostCodeResponse(String postCode) {
        return areaRepository.findByPost_PostCode(postCode);

    }
}
