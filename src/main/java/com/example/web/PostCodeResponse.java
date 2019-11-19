package com.example.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PostCodeResponse {

	@JsonProperty("code")
	private String cityCode;

	@JsonProperty("prefecture_name")
	private String prefectureName;

	@JsonProperty("city_name")
	private String cityName;

	@JsonProperty("area_name")
	private String areaName;

	@JsonProperty("old_post_code")
	private String oldPostCode;

	@JsonProperty("post_code")
	private String postCode;

	@JsonProperty("prefecture_kana")
	private String prefectureKana;

	@JsonProperty("city_kana")
	private String cityKana;

	@JsonProperty("area_kana")
	private String areaKana;

	@JsonProperty("multi_area")
	private int multiArea;

	@JsonProperty("koaza_area")
	private int koazaArea;

	@JsonProperty("chome_area")
	private int chomeArea;

	@JsonProperty("multi_post_area")
	private int multiPostArea;

	@JsonProperty("update_show")
	private int updateShow;

	@JsonProperty("change_reason")
	private int changeReason;

	@JsonProperty("prefecture_code")
	private String prefectureCode;
}
