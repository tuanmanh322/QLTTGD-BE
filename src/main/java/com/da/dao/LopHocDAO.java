package com.da.dao;

import java.io.Serializable;

import com.da.dto.LopHocSearchDTO;

public interface LopHocDAO extends Serializable,BaseDAO{
	
	void searchLopHoc(LopHocSearchDTO dto);

	void getListLopHocByIdThe(LopHocSearchDTO dto,Integer idThe);

	void getListHocBaByIdThe(LopHocSearchDTO dto,Integer idThe);
}
