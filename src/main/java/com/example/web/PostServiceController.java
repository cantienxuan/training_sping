
package com.example.web;

import com.example.model.service.AreaService;
import com.example.model.service.CityService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Component
@RestController
public class PostServiceController {
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private AreaService areaService;
	
	
	/**
	 * search address by post code
	 * @param postCode code of post
	 * @return Address List corresponding with @postCode
	 */
	@RequestMapping(value = "/post_offices/post/{postCode}", method = RequestMethod.GET)
	public ResponseEntity<?> searchByPostCodeResponse(@PathVariable("postCode") String postCode) {
		try {
			List<PostCodeResponse> postCodeResponseList = areaService.searchByPostCodeResponse(postCode);
			Map<String, Object> res = new HashMap<>();
			res.put("data", postCodeResponseList);
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (NotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * search prefecture information by prefecture code
	 * @param prefectureCode code of prefecture
	 * @return prefecture information list corresponding with @prefectureCode
	 */
	@RequestMapping(value = "/post_offices/prefectures/{prefectureCode}", method = RequestMethod.GET)
	public ResponseEntity<?> searchByPrefectureCodeResponse(
			@PathVariable("prefectureCode") String prefectureCode) {
		try {
			List<PrefectureCodeResponse> prefectureCodeResponseList = cityService.searchByPrefectureCodeResponse(prefectureCode);
			Map<String, Object> res = new HashMap<>();
			res.put("data", prefectureCodeResponseList);
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (NotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
}
