package com.example.model;

import lombok.Data;

@Data
public class PrefectureCodeResponse {
    private String prefectureCode;
    private String code;
    private String prefecture;
    private String prefectureKana;
    private String city;
    private String cityKana;
}
