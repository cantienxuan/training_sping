package com.example.logic;

import com.example.model.City;
import com.example.model.PrefectureCodeResponse;
import java.util.ArrayList;
import java.util.List;

public class PrefectureCodeLogic {

    /**
     * Hàm lấy danh sách theo prefectureCode
     * @param prefectureList prefectureList dùng lấy danh sách
     * @return danh sách prefectureCode
     */
    public List<PrefectureCodeResponse> getResponseList(List<City> prefectureList) {
        List<PrefectureCodeResponse> prefectureCodeResponseList = new ArrayList<>();

        prefectureList.forEach(ps -> {
            PrefectureCodeResponse prefectureCodeResponse = new PrefectureCodeResponse();
            prefectureCodeResponse.setCode(ps.getCode());
            prefectureCodeResponse.setCity(ps.getCity());
            prefectureCodeResponse.setCityKana(ps.getCityKana());
            prefectureCodeResponse.setPrefecture(ps.getPrefecture().getPrefecture());
            prefectureCodeResponse.setPrefectureKana(ps.getPrefecture().getPrefectureKana());
            prefectureCodeResponse.setPrefectureCode(ps.getPrefecture().getPreferctureCode());

            prefectureCodeResponseList.add(prefectureCodeResponse);
        });

        return prefectureCodeResponseList;
    }
}
