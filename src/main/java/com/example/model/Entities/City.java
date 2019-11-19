package com.example.model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "tbl_city")
@JsonIgnoreProperties({
	"hibernateLazyInitializer",
	"handler"
})
public class City implements Serializable {
	
	private static final long serialVersionUID = 1;
	
	@Id
	@Column(name = "city_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cityId;
	
	@Column(name = "code")
	private String cityCode;
	
	@Column(name = "city_kana")
	private String cityKana;
	
	@Column(name = "city")
	private String cityName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prefecture_id", insertable = false, updatable = false)
	private Prefecture prefecture;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
	private List<Area> areaList;
	
	
	public Prefecture getPrefecture() {
		return prefecture;
	}
}
