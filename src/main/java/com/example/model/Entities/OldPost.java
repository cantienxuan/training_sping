package com.example.model.Entities;

import com.example.model.Entities.Area;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "tbl_old_post")
@JsonIgnoreProperties({
	"hibernateLazyInitializer",
	"handler"
})
public class OldPost implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "old_post_id")
	private int oldPostId;
	
	@Column(name = "old_post_code")
	private String oldPostArea;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "oldPost")
	private List<Area> areaOldPostList;
	
}
