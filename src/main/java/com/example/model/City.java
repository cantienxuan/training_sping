package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tbl_city")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class City implements Serializable {
    private static final long serialVersionUID = 1;

    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityId;

    @Column(name = "code")
    private String code;
    @Column(name = "city_kana")
    private String cityKana;
    @Column(name = "city")
    private String city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prefecture_id", insertable = false, updatable = false)
    private Prefecture prefecture;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    private List<Area> areaList;

    public Prefecture getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(Prefecture prefecture) {
        this.prefecture = prefecture;
    }


    //setter getter generation

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCityKana() {
        return cityKana;
    }

    public void setCityKana(String cityKana) {
        this.cityKana = cityKana;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
