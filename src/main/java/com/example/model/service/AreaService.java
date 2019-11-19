package com.example.model.service;

import com.example.model.Entities.Area;
import com.example.web.PostCodeResponse;
import javassist.NotFoundException;

import java.util.List;

public interface AreaService {
	
	/**
	 * get arealist with postCode input Method
	 * @param postCode postCode get  from request
	 * @return PostCodeResponse corresponding with postCode input
	 * @throws NotFoundException if list output is empty
	 * @throws IllegalStateException if input is not a digit
	 */
	List<PostCodeResponse> searchByPostCodeResponse(String postCode) throws NotFoundException, IllegalStateException;
	
	/**
	 * getResponseList from postList Method
	 * @param postList list get from postCode
	 * @return PostCodeResponse List corresponding with input
	 */
	public List<PostCodeResponse> getResponseList(List<Area> postList);
}
