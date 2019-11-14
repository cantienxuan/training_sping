package com.example.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "tbl_area")
public class Area implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "area_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer areaId;

    @Column(name = "area_kana")
    private String areaKana;
    @Column (name = "area")
    private String area;
    @Column (name = "multi_post_area")
    private int multiPostArea;
    @Column (name = "koaza_area")
    private int koazaArea;
    @Column (name = "chome_area")
    private int chomeArea;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", insertable = false, updatable = false)
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", insertable = false, updatable = false)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "old_post_id", insertable = false, updatable = false)
    private OldPost oldPost;
}
