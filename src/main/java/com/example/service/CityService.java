package com.example.service;

import com.example.model.City;

import java.util.List;

public interface CityService {

    /**
     * Hàm tìm city theo prefecture code
     * @param prefectureCode prefectureCode lấy từ request
     * @return danh sách thông tin cần lấy theo req
     */
    List<City> searchByPrefectureCodeResponse(String prefectureCode);

    List<City> getAll();
}
