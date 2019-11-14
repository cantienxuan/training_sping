package com.example.controller;

import com.example.logic.PostCodeLogic;
import com.example.logic.PrefectureCodeLogic;
import com.example.model.*;
import com.example.service.AreaService;
import com.example.service.CityService;
import com.example.util.Common;
import com.example.util.Constant;
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

	@RequestMapping(value = Constant.POST_CODE_PATH, method = RequestMethod.GET)
	public ResponseEntity<?> searchByPostCodeResponse (@PathVariable("postCode") String postCode){
		postCode = Common.replaceInput(postCode);

		if (Common.checkInput(postCode) == false) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		List<Area> postList = areaService.searchByPostCodeResponse(postCode);
		if (postList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			PostCodeLogic postCodeLogic = new PostCodeLogic();
			List<PostCodeResponse> postCodeResponseList = postCodeLogic.getResponseList(postList);
			Map<String, Object> res = new HashMap<>();
			res.put("data", postCodeResponseList);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
	}

	@RequestMapping(value = Constant.PREFECTURE_CODE_PATH, method = RequestMethod.GET)
	public ResponseEntity<?> searchByPrefectureCodeResponse(
			@PathVariable("prefectureCode") String prefectureCode) {
		prefectureCode = Common.replaceInput(prefectureCode);

		//check input, input not null and is a half size digit
		if (Common.checkInput(prefectureCode) == false) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		List<City> prefectureList = cityService.searchByPrefectureCodeResponse(prefectureCode);

		//if list empty response not found, else return required list
		if (prefectureList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> res = new HashMap<>();
			PrefectureCodeLogic prefectureCodeLogic = new PrefectureCodeLogic();
			List<PrefectureCodeResponse> prefectureCodeResponseList = prefectureCodeLogic.getResponseList(prefectureList);
			res.put("data", prefectureCodeResponseList);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
	}

}
