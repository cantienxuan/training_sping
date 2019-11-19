package com.example.model.service.impl;

import com.example.model.Entities.City;
import com.example.web.PrefectureCodeResponse;
import com.example.model.repository.CityRepository;
import com.example.model.service.CityService;
import com.example.model.util.Common;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityRepository cityRepository;
	
	
	@Override
	public List<PrefectureCodeResponse> searchByPrefectureCodeResponse(String prefectureCode)
			throws NotFoundException, IllegalStateException {
		
		String prefectureCodeInput = Common.replaceInput(prefectureCode);
		// check Input valid valid
		if (Common.checkInput(prefectureCodeInput) == false) {
			throw new IllegalStateException("Input is not a half size digit");
		}
		List<City> cityList = cityRepository.findByPrefecture_PrefectureCode(prefectureCode);
		// thrown NotFoundException if check list Empty
		if (cityList.isEmpty()) {
			throw new NotFoundException("list is empty");
		}
		
		List<PrefectureCodeResponse> prefectureCodeResponseList = getResponseList(cityList);
		return prefectureCodeResponseList;
	}
	
	public List<PrefectureCodeResponse> getResponseList(List<City> prefectureList) {
		List<PrefectureCodeResponse> prefectureCodeResponseList = new ArrayList<>();
		// get response info from prefectureList
		prefectureList.forEach(ps -> {
			PrefectureCodeResponse prefectureCodeResponse = new PrefectureCodeResponse();
			prefectureCodeResponse.setCityCode(ps.getCityCode());
			prefectureCodeResponse.setCityName(ps.getCityName());
			prefectureCodeResponse.setCityKana(ps.getCityKana());
			prefectureCodeResponse.setPrefectureName(ps.getPrefecture().getPrefectureName());
			prefectureCodeResponse.setPrefectureKana(ps.getPrefecture().getPrefectureKana());
			prefectureCodeResponse.setPrefectureCode(ps.getPrefecture().getPrefectureCode());
			
			prefectureCodeResponseList.add(prefectureCodeResponse);
		});
		
		return prefectureCodeResponseList;
	}
}
