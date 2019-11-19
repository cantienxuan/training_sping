package com.example.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PrefectureCodeResponse {

	@JsonProperty("code")
	private String prefectureCode;

	@JsonProperty("city_code")
	private String cityCode;

	@JsonProperty("prefecture_name")
	private String prefectureName;

	@JsonProperty("prefecture_kana")
	private String prefectureKana;

	@JsonProperty("city_name")
	private String cityName;

	@JsonProperty("city_kana")
	private String cityKana;
}
