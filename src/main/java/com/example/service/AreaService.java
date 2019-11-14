package com.example.service;

import com.example.model.Area;

import java.util.List;

public interface AreaService {

    /**
     * Hàm tìm city theo post code
     * @param postCode postCode lấy từ request
     * @return danh sách thông tin cần lấy theo req
     */
    List<Area> searchByPostCodeResponse(String postCode);
}
