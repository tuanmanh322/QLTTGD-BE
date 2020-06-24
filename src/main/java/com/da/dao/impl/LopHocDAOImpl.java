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
public class LopHocDAOImpl extends AbstractDAO implements LopHocDAO {
    private final Logger log = LoggerFactory.getLogger(LopHocDAOImpl.class);

    @Override
    public void searchLopHoc(LopHocSearchDTO dto) {
        log.info("Start dao searchLopHoc with :{}", dto);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> parameter = new HashMap<>();
        sb.append(" select  lo.id ,lo.ma_lop as maLop,");
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
            sb.append(" and lo.tenlop like :p_tenlop ");
            parameter.put("p_tenlop", "%" + dto.getTenLop().trim() + "%");
        }
        if (dto.getEndDate() != null && dto.getStartDate() != null) {
            sb.append(" and lo.thoigianbatdau >= :p_startdate and lo.thoigianbatdau <= :p_enddate ");
            parameter.put("p_startdate", dto.getStartDate());
            parameter.put("p_enddate", dto.getEndDate());
        }
        if (dto.getOrders() != null && !dto.getOrders().isEmpty()) {
            sb.append(" order by ");
            dto.getOrders().forEach(order -> {
                String property = StringUtils.trimToEmpty(order.getProperty());
                switch (property) {
                    case "tenlop":
                        sb.append(" lo.tenlop ").append(getOrderBy(order.isAscending())).append(",");
                        break;
                }
            });
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(" order by lo.tenlop ");
        }
        searchAndCountTotal(dto, sb.toString(), parameter, LopHocSearchDTO.class);
    }

    @Override
    public void getListLopHocByIdThe(LopHocSearchDTO dto, Integer idThe) {
        log.info("Start dao getListLopHocByIdThe with :{} and idThe: {}", dto, idThe);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> parameter = new HashMap<>();
        sb.append(" select distinct lo.id ,lo.ma_lop as maLop,");
        sb.append(" lo.tenlop as tenLop,");
        sb.append(" mh.tenmonhoc as tenMonHoc,");
        sb.append(" lo.thoigianbatdau  as ngayKhaiGiang,");
        sb.append(" lo.thoigianketthuc  as ngayKetThuc,");
        sb.append(" lo.siso  as siSo,");
        sb.append(" lo.kip_day  as kipDay,");
        sb.append(" lo.diadiem as diaDiem,");
        sb.append(" lo.hocphi as hocPhi");
        sb.append(" from LOP as lo");
        sb.append(" left join MONHOC as mh on lo.ma_monhoc = mh.ma_monhoc");
        sb.append(" left join USER_LOP_MAPPER as ulm on ulm.id_lop = lo.id");
        sb.append(" left join USERS as u on u.id = ulm.id_user");
        sb.append(" where 1=1");
        if (idThe != null) {
            sb.append(" and u.ma_the=:p_idThe");
            parameter.put("p_idThe", idThe);
        }
        if (StringUtils.isNotBlank(dto.getTenLop())) {
            sb.append(" and lo.tenlop like :p_tenlop ");
            parameter.put("p_tenlop", "%" + dto.getTenLop().trim() + "%");
        }
        if (dto.getEndDate() != null && dto.getStartDate() != null) {
            sb.append(" and lo.thoigianbatdau >= :p_startdate and lo.thoigianbatdau <= :p_enddate ");
            parameter.put("p_startdate", dto.getStartDate());
            parameter.put("p_enddate", dto.getEndDate());
        }
        if (dto.getOrders() != null && !dto.getOrders().isEmpty()) {
            sb.append(" order by ");
            dto.getOrders().forEach(order -> {
                String property = StringUtils.trimToEmpty(order.getProperty());
                switch (property) {
                    case "tenlop":
                        sb.append(" lo.tenlop ").append(getOrderBy(order.isAscending())).append(",");
                        break;
                }
            });
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(" order by lo.tenlop ");
        }
        searchAndCountTotal(dto, sb.toString(), parameter, LopHocSearchDTO.class);
    }

    @Override
    public void getListHocBaByIdThe(LopHocSearchDTO dto, Integer idThe) {
        log.info("Start dao getListHocBaByIdThe with :{} and idThe: {}", dto, idThe);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> parameter = new HashMap<>();
        sb.append(" select distinct lo.id ,lo.ma_lop as maLop,");
        sb.append(" lo.tenlop as tenLop,");
        sb.append(" mh.tenmonhoc as tenMonHoc,");
        sb.append(" lo.thoigianbatdau  as ngayKhaiGiang,");
        sb.append(" lo.thoigianketthuc  as ngayKetThuc,");
        sb.append(" lo.siso  as siSo,");
        sb.append(" lo.kip_day  as kipDay,");
        sb.append(" lo.diadiem as diaDiem,");
        sb.append(" lo.hocphi as hocPhi,");
        sb.append(" lo.days as thu,");
        sb.append(" lo.giobatdau as gioBatDau,");
        sb.append(" lo.gioketthuc as gioKetThuc,");
        sb.append(" d.diemmieng as diemMieng,");
        sb.append(" d.diem15p as diem15p,");
        sb.append(" d.diem90p as diem90p,");
        sb.append(" d.diemtb as diemTB");
        sb.append(" from LOP as lo");
        sb.append(" left join MONHOC as mh on lo.ma_monhoc = mh.ma_monhoc");
        sb.append(" left join USER_LOP_MAPPER as ulm on ulm.id_lop = lo.id");
        sb.append(" left join USERS as u on u.id = ulm.id_user");
        sb.append(" left join USERS_DIEM_MAP as udm on udm.id_diem = u.id");
        sb.append(" left join DIEM as d on d.id = udm.id_diem ");
        sb.append(" where 1=1");
        if (idThe != null) {
            sb.append(" and u.ma_the=:p_idThe");
            parameter.put("p_idThe", idThe);
        }
        if (StringUtils.isNotBlank(dto.getTenLop())) {
            sb.append(" and lo.tenlop like :p_tenlop ");
            parameter.put("p_tenlop", "%" + dto.getTenLop().trim() + "%");
        }
        if (dto.getEndDate() != null && dto.getStartDate() != null) {
            sb.append(" and lo.thoigianbatdau >= :p_startdate and lo.thoigianbatdau <= :p_enddate ");
            parameter.put("p_startdate", dto.getStartDate());
            parameter.put("p_enddate", dto.getEndDate());
        }
        if (dto.getOrders() != null && !dto.getOrders().isEmpty()) {
            sb.append(" order by ");
            dto.getOrders().forEach(order -> {
                String property = StringUtils.trimToEmpty(order.getProperty());
                switch (property) {
                    case "tenlop":
                        sb.append(" lo.tenlop ").append(getOrderBy(order.isAscending())).append(",");
                        break;
                }
            });
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(" order by lo.tenlop ");
        }
        searchAndCountTotal(dto, sb.toString(), parameter, LopHocSearchDTO.class);
    }

}
