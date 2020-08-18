package com.da.dao.impl;

import com.da.dao.DiemDAO;
import com.da.dto.DiemDTO;
import com.da.dto.DiemSearchDTO;
import com.da.dto.DiemToExcelDTO;
import com.da.dto.HocSinhDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DiemDAOImpl extends AbstractDAO implements DiemDAO {
    private final Logger log = LoggerFactory.getLogger(DiemDAOImpl.class);

    public void searchDiem(DiemDTO dto) {
        log.info("Start dao searchHS with :{}", dto);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> parameter = new HashMap<>();
        sb.append(" select d.id,");
        sb.append(" d.ma_diem as ma_diem,");
        sb.append(" d.diemmieng as diemHS1 ,");
        sb.append(" d.diem15p as diemHS2,");
        sb.append(" d.diem90p as diemHS3, ");
        sb.append(" u.name as username, ");
        sb.append(" u.id as idUser,");
        sb.append(" t.ma_the as maThe");
        sb.append(" from diem as d ");
        sb.append(" left join users_diem_map as udm on udm.id_diem = d.id");
        sb.append(" left join users as u on u.id = udm.id_user");
        sb.append(" left join the as t on t.id = u.ma_the ");
        sb.append(" where 1 = 1");
        if (StringUtils.isNotBlank(dto.getUsername())) {
            sb.append(" and u.name like :p_name ");
            parameter.put("p_name", "%" + dto.getUsername().trim() + "%");
        }
        if (StringUtils.isNotBlank(dto.getMaThe())) {
            sb.append(" and t.ma_the like :pma_the ");
            parameter.put("pma_the", "%" + dto.getMaThe().trim() + "%");
        }
        if (dto.getOrders() != null && !dto.getOrders().isEmpty()) {
            sb.append(" order by ");
            dto.getOrders().forEach(order -> {
                String property = StringUtils.trimToEmpty(order.getProperty());
                switch (property) {
                    case "ma_diem":
                        sb.append(" d.ma_diem ").append(getOrderBy(order.isAscending())).append(",");
                        break;
                }
            });
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(" order by u.name ");
        }
        searchAndCountTotal(dto, sb.toString(), parameter, DiemDTO.class);
    }

    @Override
    public void searchDiemProfile(DiemSearchDTO dto, Integer idThe) {
        log.info("Start dao searchDiemProfile with :{} and idTHe: {}", dto, idThe);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
//        sb.append(" select d.id ,");
//        sb.append(" d.ma_diem as maDiem,");
//        sb.append(" d.ma_lop as maLop,");
//        sb.append(" d.diemmieng as diemMieng,");
//        sb.append(" d.diem15p as diem15p,");
//        sb.append(" d.diem90p as diem90p,");
//        sb.append(" d.diemtb as diemTB, ");
//        sb.append(" u.name as userName, ");
//        sb.append(" u.ngaysinh as ngaySinh, ");
//        sb.append(" u.id as idUser, ");
//        sb.append(" t.ma_the as maThe,");
//        sb.append(" lo.kip_day as kipDay,");
//        sb.append(" lo.tenlop as tenLop");
//        sb.append(" from diem as d");
//        sb.append(" left join lop as lo on lo.id = d.ma_lop");
//        sb.append(" left join users_diem_map as udm on udm.id_diem = d.id");
//        sb.append(" left join users as u on u.id = udm.id_user");
//        sb.append(" left join the as t on t.id = u.ma_the");
//        sb.append(" where 1=1 ");
//        if (idThe != null){
//            sb.append(" and t.id=:p_idThe ");
//            params.put("p_idThe",idThe);
//        }
//
//        if (StringUtils.isNotBlank(dto.getKipDay())){
//            sb.append(" and lo.kip_day like :p_kipDay");
//            params.put("p_kipDay","%" + dto.getKipDay().trim() +"%");
//        }
//        if (StringUtils.isNotBlank(dto.getTenLop())){
//            sb.append(" and lo.tenlop like :p_tenLop");
//            params.put("p_tenLop","%" + dto.getTenLop().trim() +"%");
//        }
//        sb.append(" order by t.ma_the");
//        searchAndCountTotal(dto,sb.toString(),params,DiemSearchDTO.class);
        sb.append(" with info_gv");
        sb.append(" as(select distinct u.id idUser,");
        sb.append(" u.name, ");
        sb.append("  l.id as idLop,");
        sb.append(" l.tenlop");
        sb.append(" from users u ");
        sb.append(" left join user_lop_mapper ulm on ulm.id_user = u.id and ulm.trangthai = 1");
        sb.append(" left join lop l on l.id = ulm.id_lop");
        sb.append(" where 1 = 1   ");
        sb.append(" and  u.ma_the =" + idThe + "),");
        sb.append(" info_hs as ");
        sb.append(" (select distinct l.kip_day as kipDay,");
        sb.append("  l.tenlop as tenLop,");
        sb.append(" mh.tenmonhoc as tenMonHoc,");
        sb.append(" u.id as idHS");
        sb.append(" from users u ");
        sb.append(" left join user_lop_mapper ulm on ulm.id_user = u.id and ulm.trangthai = 1");
        sb.append(" left join lop l on l.id = ulm.id_lop");
        sb.append(" left join info_gv igv on igv.idLop = l.id");
        sb.append(" left join monhoc mh on mh.id = l.ma_monhoc");
        sb.append(" where igv.idLop = l.id  ");
        if (StringUtils.isNotBlank(dto.getKipDay())) {
            sb.append(" and l.kip_day like :p_kipDay");
            params.put("p_kipDay", "%" + dto.getKipDay().trim() + "%");
        }
        if (StringUtils.isNotBlank(dto.getTenLop())) {
            sb.append(" and l.tenlop like :p_tenLop");
            params.put("p_tenLop", "%" + dto.getTenLop().trim() + "%");
        }
        sb.append(" )");
        sb.append(" select distinct d.id,");
        sb.append("  d.ma_diem as maDiem,");
        sb.append("    t.ma_the as maThe,");
        sb.append("  u.name as userName,");
        sb.append(" u.ngaysinh as ngaySinh,");
        sb.append("  d.diemmieng as diemMieng,");
        sb.append(" d.diem15p as diem15p,");
        sb.append(" d.diem90p as diem90p,");
        sb.append(" d.diemtb as diemTB,");
        sb.append("  info_hs.* ");
        sb.append(" from diem d ");
        sb.append(" left join users_diem_map udm on udm.id_diem = d.id");
        sb.append(" left join users u on u.id = udm.id_user");
        sb.append(" left join info_hs on info_hs.idHS = u.id");
        sb.append(" left join the t on t.id = u.ma_the");
        sb.append(" where 1=1 and u.is_teacher =0 and info_hs.idHS = udm.id_user");



        sb.append(" order by t.ma_the");
        searchAndCountTotal(dto, sb.toString(), params, DiemSearchDTO.class);
    }

    @Override
    public void searchDiemProfileStudent(DiemSearchDTO dto, Integer idThe) {
        log.info("Start dao searchDiemProfileStudent with :{} and idTHe: {}", dto, idThe);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        sb.append(" with info_gv");
        sb.append(" as(select distinct u.id idUser,");
        sb.append(" u.name, ");
        sb.append("  l.id as idLop,");
        sb.append(" l.tenlop");
        sb.append(" from users u ");
        sb.append(" left join user_lop_mapper ulm on ulm.id_user = u.id and ulm.trangthai = 1 and ulm.is_teach = 0");
        sb.append(" left join lop l on l.id = ulm.id_lop");
        sb.append(" where 1 = 1   ");
        sb.append(" and  u.ma_the =" + idThe + "),");
        sb.append(" info_hs as ");
        sb.append(" (select distinct l.kip_day as kipDay,");
        sb.append("  l.tenlop as tenLop,");
        sb.append("  l.thoigianbatdau as ngayKhaiGiang,");
        sb.append("  l.thoigianketthuc as ngayKetThuc,");
        sb.append("  l.siso as siSo,");
        sb.append("  l.diadiem as diaDiem,");
        sb.append("  l.hocphi as hocPhi,");
        sb.append("  l.ma_lop as ma_lop,");
        sb.append(" mh.tenmonhoc as tenMonHoc,");
        sb.append(" u.id as idHS");
        sb.append(" from users u ");
        sb.append(" left join user_lop_mapper ulm on ulm.id_user = u.id and ulm.trangthai = 1");
        sb.append(" left join lop l on l.id = ulm.id_lop");
        sb.append(" left join info_gv igv on igv.idLop = l.id");
        sb.append(" left join monhoc mh on mh.id = l.ma_monhoc");
        sb.append(" where igv.idLop = l.id  ");
        if (StringUtils.isNotBlank(dto.getKipDay())) {
            sb.append(" and l.kip_day like :p_kipDay");
            params.put("p_kipDay", "%" + dto.getKipDay().trim() + "%");
        }
        if (StringUtils.isNotBlank(dto.getTenLop())) {
            sb.append(" and l.tenlop like :p_tenLop");
            params.put("p_tenLop", "%" + dto.getTenLop().trim() + "%");
        }
        sb.append(" )");
        sb.append(" select distinct d.id,");
        sb.append("  d.ma_diem as maDiem,");
        sb.append("    t.ma_the as maThe,");
        sb.append("  u.name as userName,");
        sb.append(" u.ngaysinh as ngaySinh,");
        sb.append("  d.diemmieng as diemMieng,");
        sb.append(" d.diem15p as diem15p,");
        sb.append(" d.diem90p as diem90p,");
        sb.append(" d.diemtb as diemTB,");
        sb.append("  info_hs.* ");
        sb.append(" from diem d ");
        sb.append(" left join users_diem_map udm on udm.id_diem = d.id");
        sb.append(" left join users u on u.id = udm.id_user");
        sb.append(" left join info_hs on info_hs.idHS = u.id");
        sb.append(" left join the t on t.id = u.ma_the");
        sb.append(" where 1=1 and u.is_teacher =0 and info_hs.idHS = udm.id_user");
        sb.append(" order by u.name");
        searchAndCountTotal(dto, sb.toString(), params, DiemSearchDTO.class);
    }

    @Override
    public List<DiemToExcelDTO> getAllByIdThe(Integer idThe) {
        log.info("Start dao searchDiemProfile with idTHe: {}", idThe);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        sb.append(" with info_gv");
        sb.append(" as(select distinct u.id idUser,");
        sb.append(" u.name, ");
        sb.append("  l.id as idLop,");
        sb.append(" l.tenlop");
        sb.append(" from users u ");
        sb.append(" left join user_lop_mapper ulm on ulm.id_user = u.id and ulm.trangthai = 1");
        sb.append(" left join lop l on l.id = ulm.id_lop");
        sb.append(" where 1 = 1   ");
        sb.append(" and  u.ma_the =" + idThe + "),");
        sb.append(" info_hs as ");
        sb.append(" (select distinct l.kip_day as kipDay,");
        sb.append("  l.tenlop as tenLop,");
        sb.append(" mh.tenmonhoc as tenMonHoc,");
        sb.append(" u.id as idHS");
        sb.append(" from users u ");
        sb.append(" left join user_lop_mapper ulm on ulm.id_user = u.id and ulm.trangthai = 1");
        sb.append(" left join lop l on l.id = ulm.id_lop");
        sb.append(" left join info_gv igv on igv.idLop = l.id");
        sb.append(" left join monhoc mh on mh.id = l.ma_monhoc");
        sb.append(" where igv.idLop = l.id) ");
        sb.append(" select distinct d.id,");
        sb.append("  d.ma_diem as maDiem,");
        sb.append("    t.ma_the as maThe,");
        sb.append("  u.name as userName,");
        sb.append(" u.ngaysinh as ngaySinh,");
        sb.append("  d.diemmieng as diemMieng,");
        sb.append(" d.diem15p as diem15p,");
        sb.append(" d.diem90p as diem90p,");
        sb.append(" d.diemtb as diemTB,");
        sb.append("  info_hs.* ");
        sb.append(" from diem d ");
        sb.append(" left join users_diem_map udm on udm.id_diem = d.id");
        sb.append(" left join users u on u.id = udm.id_user");
        sb.append(" left join info_hs on info_hs.idHS = u.id");
        sb.append(" left join the t on t.id = u.ma_the");
        sb.append(" where 1=1 and u.is_teacher =0 and info_hs.idHS = udm.id_user");
        return namedParameterJdbcTemplate().query(sb.toString(), params, new BeanPropertyRowMapper<>(DiemToExcelDTO.class));
    }
}
