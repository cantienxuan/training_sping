package com.example.model.Entities;

import com.example.model.Entities.Area;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tbl_post")
@Data
@JsonIgnoreProperties({
	"hibernateLazyInitializer",
	"handler"
})
public class Post implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "post_id")
	private int postId;
	
	@Column(name = "post_code")
	private String postCode;
	
	@Column(name = "multi_area")
	private int multiArea;
	
	@Column(name = "update_show")
	private int updateShow;
	
	@Column(name = "change_reason")
	private int changeReason;
	
	@OneToMany(targetEntity = Area.class, fetch = FetchType.LAZY, mappedBy = "post")
	private List<Area> areaPostList;
	
}
