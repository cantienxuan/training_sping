package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tbl_post")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Post implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private int postId;
    @Column (name = "post_code")
    private String postCode;
    @Column (name = "multi_area")
    private int multiArea;
    @Column (name = "update_show")
    private int updateShow;
    @Column (name = "change_reason")
    private int changeReason;

    @OneToMany(targetEntity = Area.class, fetch = FetchType.LAZY, mappedBy = "post")
    private List<Area> areaPostList;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public int getMultiArea() {
        return multiArea;
    }

    public void setMultiArea(int multiArea) {
        this.multiArea = multiArea;
    }

    public int getUpdateShow() {
        return updateShow;
    }

    public void setUpdateShow(int updateShow) {
        this.updateShow = updateShow;
    }

    public int getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(int changeReason) {
        this.changeReason = changeReason;
    }
}
