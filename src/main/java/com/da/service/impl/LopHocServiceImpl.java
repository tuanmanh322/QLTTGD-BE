package com.da.service.impl;
import com.da.model.Monhoc;
import com.da.repository.LopRepository;
import com.da.repository.MonhocRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.da.dao.LopHocDAO;
import com.da.dto.LopHocDTO;
import com.da.dto.LopHocSearchDTO;
import com.da.exception.ErrorCode;
import com.da.exception.ResultException;
import com.da.model.Lop;
import com.da.service.LopHocService;

import java.util.Date;

@Service
@Transactional
public class LopHocServiceImpl implements LopHocService{
	private final Logger log = LoggerFactory.getLogger(LopHocServiceImpl.class);
	
	private final ModelMapper modelMap;
	
	private final LopHocDAO lopHocDao;

	private final MonhocRepository monhocRepository;

	private final LopRepository lopRepository;

	public LopHocServiceImpl(ModelMapper modelMap, LopHocDAO lopHocDao, MonhocRepository monhocRepository, LopRepository lopRepository) {
		this.modelMap = modelMap;
		this.lopHocDao = lopHocDao;
		this.monhocRepository = monhocRepository;
		this.lopRepository = lopRepository;
	}

	@Override
	public void searchLopHoc(LopHocSearchDTO dto) {
		log.info(" start service to searchLopHoc with :{}",dto);
		lopHocDao.searchLopHoc(dto);
	}

	@Override
	public void add(LopHocDTO dto) throws ResultException {
		log.info(" start service to addLopHoc with :{}",dto);
		Lop lop = modelMap.map(dto, Lop.class);
		Monhoc monhoc = monhocRepository.findByTenmonhoc(dto.getMaMonhoc());
		if (monhoc.getId() == null){
			throw new ResultException(ErrorCode.RECORD_NOT_FOUND);
		}
		lop.setMaMonhoc(monhoc.getMaMonhoc());
		lopHocDao.save(lop);
	}

	@Override
	public void update(LopHocDTO dto) throws ResultException {
		log.info(" start service to editLopHoc with :{}",dto);
		Lop lop = lopHocDao.findById(dto.getId(), Lop.class).get();
		if (lop.getId() == null) {
			throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
		}
		Lop check = lopRepository.findByTenlop(dto.getTenlop());
		if (check.getId() != null){
			throw new ResultException(ErrorCode.RECORD_EXISTED);
		}
		lop = modelMap.map(dto, Lop.class);
		lopHocDao.update(lop);
	}

	@Override
	public void delete(Integer id) throws ResultException {
		log.info(" start service to delete Lop with id:{}",id);
		Lop lop = lopHocDao.findById(id, Lop.class).get();
		if (lop.getId() == null) {
			throw new ResultException(ErrorCode.RECORD_NOT_EXISTED);
		}
		lopHocDao.delete(lop);
	}

	@Override
	public LopHocDTO findById(Integer id) {
		Lop lop = lopHocDao.findById(id, Lop.class).get();
		LopHocDTO dto = modelMap.map(lop, LopHocDTO.class);
		return dto;
	}

}
