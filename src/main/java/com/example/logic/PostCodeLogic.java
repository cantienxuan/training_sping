package com.example.logic;

import com.example.model.Area;
import com.example.model.PostCodeResponse;
import com.example.util.Common;

import java.util.ArrayList;
import java.util.List;

public class PostCodeLogic {

    /**
     * Hàm lấu danh sách postCodeResponseList trả về tương ứng với postCode người dùng tìm kiếm
     * @param postList danh sách postList lấy được theo postCode
     * @return thông tin cần đưa ra theo req
     */
    public List<PostCodeResponse> getResponseList(List<Area> postList) {
        List<PostCodeResponse> postCodeResponseList = new ArrayList<>();
        for (Area area: postList) {
            PostCodeResponse codeResponse = new PostCodeResponse();
            codeResponse.setCode(area.getCity().getCode());
            codeResponse.setPrefecture(area.getCity().getPrefecture().getPrefecture());
            codeResponse.setCity(area.getCity().getCity());
            codeResponse.setArea(area.getArea());
            codeResponse.setOldPostCode(area.getOldPost().getOldPostArea());
            codeResponse.setPostCode(area.getPost().getPostCode());
            codeResponse.setCityKana(area.getCity().getCityKana());
            codeResponse.setAreaKana(area.getAreaKana());
            codeResponse.setMultiArea(area.getMultiPostArea());
            codeResponse.setKoazaArea(area.getKoazaArea());
            codeResponse.setChomeArea(area.getChomeArea());
            codeResponse.setMultiPostArea(area.getMultiPostArea());
            codeResponse.setUpdateShow(area.getPost().getUpdateShow());
            codeResponse.setChangeReason(area.getPost().getChangeReason());
            codeResponse.setPrefectureCode(area.getCity().getPrefecture().getPrefectureCode());
            postCodeResponseList.add(codeResponse);
        }
        return postCodeResponseList;
    }
}
