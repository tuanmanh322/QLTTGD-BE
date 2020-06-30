package com.da.service;

import com.da.dto.LopHocDTO;
import com.da.dto.LopHocSearchDTO;
import com.da.exception.ResultException;
import com.da.model.Lop;

import java.util.List;

public interface LopHocService {
	void searchLopHoc(LopHocSearchDTO dto);
	
	void add(LopHocDTO dto)throws ResultException;
	
	void update(LopHocDTO dto)throws ResultException;
	
	void delete(Integer id)throws ResultException;
	
	LopHocDTO findById(Integer id);

	void getListLopHocByIdThe(LopHocSearchDTO dto);

	void getListHocBaByIdThe(LopHocSearchDTO dto);

	void searchLopHocFilter(LopHocSearchDTO dto);

	List<Lop> getLopUnExpired();

	List<LopHocDTO> getLopByMaThe(String maThe);
}
