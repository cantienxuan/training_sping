package com.example.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tbl_old_post")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class OldPost implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="old_post_id")
    private int oldPostId;
    @Column (name = "old_post_code")
    private String oldPostArea;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "oldPost")
    private List<Area> areaOldPostList;


    //setter getter generation

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getOldPostId() {
        return oldPostId;
    }

    public void setOldPostId(int oldPostId) {
        this.oldPostId = oldPostId;
    }

    public String getOldPostArea() {
        return oldPostArea;
    }

    public void setOldPostArea(String oldPostArea) {
        this.oldPostArea = oldPostArea;
    }
}
