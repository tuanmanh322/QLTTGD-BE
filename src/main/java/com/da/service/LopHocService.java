package com.da.service;

import com.da.dto.LopHocDTO;
import com.da.dto.LopHocSearchDTO;
import com.da.exception.ResultException;

import java.util.List;

public interface LopHocService {
	void searchLopHoc(LopHocSearchDTO dto);
	
	void add(LopHocDTO dto)throws ResultException;
	
	void update(LopHocDTO dto)throws ResultException;
	
	void delete(Integer id)throws ResultException;
	
	LopHocDTO findById(Integer id);

	void getListLopHocByIdThe(LopHocSearchDTO dto);

	void getListHocBaByIdThe(LopHocSearchDTO dto);
}
