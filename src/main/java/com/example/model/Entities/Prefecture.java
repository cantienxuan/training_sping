package com.example.model.Entities;

import com.example.model.Entities.City;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "tbl_prefecture")
@JsonIgnoreProperties({
	"hibernateLazyInitializer",
	"handler"
})
public class Prefecture implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "prefecture_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer prefectureId;
	
	@Column(name = "prefecture")
	private String prefectureName;
	
	@Column(name = "prefecture_kana")
	private String prefectureKana;
	
	@Column(name = "prefecture_code")
	private String prefectureCode;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prefecture")
	private List<City> cityList;
	
	
	public Prefecture() {
		
	}
	
}
