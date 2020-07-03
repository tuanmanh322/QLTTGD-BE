package com.da.dao;

import java.io.Serializable;
import java.util.List;

import com.da.dto.LopHocDTO;
import com.da.dto.LopHocRequestDTO;
import com.da.dto.LopHocSearchDTO;

public interface LopHocDAO extends Serializable,BaseDAO{
	
	void searchLopHoc(LopHocSearchDTO dto);

	void getListLopHocByIdThe(LopHocSearchDTO dto,Integer idThe);

	void getListHocBaByIdThe(LopHocSearchDTO dto,Integer idThe);

	void searchLopHocFilter(LopHocSearchDTO dto);

	List<LopHocDTO> getLopByMaThe(String maThe);

	void getListLopRequest(LopHocRequestDTO lopHocRequestDTO);

	List<LopHocDTO> getLopUnexpired();
}
