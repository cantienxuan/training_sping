package com.example.model.service.impl;

import com.example.model.Entities.Area;
import com.example.web.PostCodeResponse;
import com.example.model.repository.AreaRepository;
import com.example.model.service.AreaService;
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
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	private AreaRepository areaRepository;
	
	
	@Override
	public List<PostCodeResponse> searchByPostCodeResponse(String postCode)
			throws IllegalStateException, NotFoundException {
		
		String postCodeInput = Common.replaceInput(postCode);
		// check Input valid valid
		if (Common.checkInput(postCode) == false) {
			throw new IllegalStateException("input is not a half size number");
		}
		List<Area> areaList = areaRepository.findByPost_PostCode(postCodeInput);
		// thrown NotFoundException if check list Empty
		if (areaList.isEmpty()) {
			throw new NotFoundException("list is empty");
		}
		List<PostCodeResponse> postCodeResponseList = getResponseList(areaList);
		return postCodeResponseList;
	}
	
	public List<PostCodeResponse> getResponseList(List<Area> postList) {
		List<PostCodeResponse> postCodeResponseList = new ArrayList<>();
		// get response info from postList
		for (Area area : postList) {
			PostCodeResponse codeResponse = new PostCodeResponse();
			codeResponse.setCityCode(area.getCity().getCityCode());
			codeResponse.setPrefectureName(area.getCity().getPrefecture().getPrefectureName());
			codeResponse.setCityName(area.getCity().getCityName());
			codeResponse.setAreaName(area.getAreaName());
			codeResponse.setOldPostCode(area.getOldPost().getOldPostArea());
			codeResponse.setPostCode(area.getPost().getPostCode());
			codeResponse.setCityKana(area.getCity().getCityKana());
			codeResponse.setAreaKana(area.getAreaKana());
			codeResponse.setMultiArea(area.getMultiPostArea());
			codeResponse.setKoazaArea(area.getKoazaArea());
			codeResponse.setChomeArea(area.getChomeArea());
			codeResponse.setMultiPostArea(area.getMultiPostArea());
			codeResponse.setUpdateShow(area.getPost().getUpdateShow());
			codeResponse.setChangeReason(area.getPost().getChangeReason());
			codeResponse.setPrefectureCode(area.getCity().getPrefecture().getPrefectureCode());
			postCodeResponseList.add(codeResponse);
		}
		return postCodeResponseList;
	}
}
