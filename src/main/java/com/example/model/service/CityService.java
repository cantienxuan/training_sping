package com.example.model.service;

import com.example.model.Entities.City;
import com.example.web.PrefectureCodeResponse;
import javassist.NotFoundException;

import java.util.List;

public interface CityService {
	
	/**
	 * get Citylist with prefectureCode input Method
	 * @param prefectureCode prefectureCode get from request
	 * @return CityList corresponding with prefectureCode input
	 * @throws NotFoundException if list output is empty
	 * @throws IllegalStateException if input is not a digit
	 */
	List<PrefectureCodeResponse> searchByPrefectureCodeResponse(String prefectureCode) throws NotFoundException, IllegalStateException;
	
	/**
	 * getResponseList from cityList Method
	 * @param prefectureList list get from prefectureCode
	 * @return PrefectureCodeResponse List corresponding with input
	 */
	public List<PrefectureCodeResponse> getResponseList(List<City> prefectureList);
}
