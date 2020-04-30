package com.da.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.Order;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.da.dao.LopHocDAO;
import com.da.dto.LopHocSearchDTO;

import lombok.extern.java.Log;

@Repository
public class LopHocDAOImpl extends AbstractDAO implements LopHocDAO{
	private final Logger log = LoggerFactory.getLogger(LopHocDAOImpl.class);
	
	
	@Override
	public void searchLopHoc(LopHocSearchDTO dto) {
		log.info("Start dao searchLopHoc with :{}",dto);
		final StringBuilder sb = new StringBuilder();
		Map<String, Object> parameter = new HashMap<>();
		sb.append(" select TOP 10000 lo.id ,lo.ma_lop as maLop,");
		sb.append(" lo.tenlop as tenLop,");
		sb.append(" mh.tenmonhoc as tenMonHoc,");
		sb.append(" lo.thoigianbatdau  as ngayKhaiGiang,");
		sb.append(" lo.thoigianketthuc  as ngayKetThuc,");
		sb.append(" lo.siso  as siSo,");
		sb.append(" lo.diadiem as diaDiem,");
		sb.append(" lo.hocphi as hocPhi");
		sb.append(" from LOP as lo");
		sb.append(" left join MONHOC as mh on lo.ma_monhoc = mh.ma_monhoc");
		sb.append(" where 1=1");
		if (StringUtils.isNotBlank(dto.getTenLop())) {
			sb.append(" and lo.ten_lop like :p_tenlop ");
			parameter.put("p_tenlop", "%" + dto.getTenLop().trim() + "%");
		}
//		if (dto.getOrderDTOS() != null && !dto.getOrderDTOS().isEmpty()) {
//			sb.append(" order by ");
//			dto.getOrderDTOS().forEach(order ->{
//				String property  = StringUtils.trimToEmpty(order.getProperty());
//				switch (property) {
//				case "tenlop":
//					sb.append(" lo.tenlop ").append(getOrderBy(order.isAscending())).append(",");
//					break;
//				}
//			});
//			sb.deleteCharAt(sb.length() -1 );
//		}else {
//			sb.append(" order by lo.tenlop ");
//		}
		searchAndCountTotal(dto, sb.toString(), parameter,LopHocSearchDTO.class);
	}

}
