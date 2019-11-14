package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tbl_prefecture")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Prefecture implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "prefecture_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer prefectureId;
	
	@Column(name = "prefecture")
	private String prefecture;
	
	@Column(name = "prefecture_kana")
	private String prefectureKana;
	
	@Column(name = "prefecture_code")
	private String prefectureCode;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prefecture")
	private List<City> cityList;

	public Prefecture() {

	}

	//setter getter generation


	public void setPrefectureId(Integer prefectureId) {
		this.prefectureId = prefectureId;
	}

	public String getPrefectureCode() {
		return prefectureCode;
	}
	
	public void setPrefectureCode(String prefectureCode) {
		this.prefectureCode = prefectureCode;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	public int getPrefectureId() {
		return prefectureId;
	}
	
	public void setPrefectureId(int prefectureId) {
		this.prefectureId = prefectureId;
	}
	
	public String getPrefecture() {
		return prefecture;
	}
	
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}
	
	public String getPrefectureKana() {
		return prefectureKana;
	}
	
	public void setPrefectureKana(String prefectureKana) {
		this.prefectureKana = prefectureKana;
	}
	
	public String getPreferctureCode() {
		return prefectureCode;
	}
	
	public void setPreferctureCode(String preferctureCode) {
		this.prefectureCode = preferctureCode;
	}
}
