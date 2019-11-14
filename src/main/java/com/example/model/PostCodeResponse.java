package com.example.model;

import lombok.Data;

@Data
public class PostCodeResponse {

    private String code;
    private String prefecture;
    private String city;
    private String area;
    private String oldPostCode;
    private String postCode;
    private String prefectureKana;
    private String cityKana;
    private String areaKana;
    private int multiArea;
    private int koazaArea;
    private int chomeArea;
    private int multiPostArea;
    private int updateShow;
    private int changeReason;
    private String prefectureCode;
}
