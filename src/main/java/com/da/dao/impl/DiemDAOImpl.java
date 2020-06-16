package com.da.dao.impl;

import com.da.dao.DiemDAO;
import com.da.dto.DiemDTO;
import com.da.dto.DiemSearchDTO;
import com.da.dto.HocSinhDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DiemDAOImpl extends AbstractDAO implements DiemDAO {
    private final Logger log = LoggerFactory.getLogger(DiemDAOImpl.class);
    public void searchDiem(DiemDTO dto){
        log.info("Start dao searchHS with :{}",dto);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> parameter = new HashMap<>();
        sb.append(" select d.id,");
        sb.append(" d.ma_diem as ma_diem,");
        sb.append(" d.diemmieng as diemHS1 ,");
        sb.append(" d.diem15p as diemHS2,");
        sb.append(" d.diem90p as diemHS3, ");
        sb.append(" d.id_user as MaHocSinh, ");
        sb.append(" u.name as Name, ");
        sb.append(" from diem as d ");
        sb.append(" left join (users as u left join lop l ) on u.id_user = d.id_user and l.ma_lop = u.ma_lop where 1=1");
        if (StringUtils.isNotBlank(dto.getName())) {
            sb.append(" and u.name like :p_name ");
            parameter.put("p_name", "%" + dto.getName().trim() + "%");
        }
        if (StringUtils.isNotBlank(dto.getTenLop())) {
            sb.append(" and l.tenlop like :p_tenlop ");
            parameter.put("p_tenlop", "%" + dto.getTenLop().trim() + "%");
        }
        if (dto.getOrders() != null && !dto.getOrders().isEmpty()) {
            sb.append(" order by ");
            dto.getOrders().forEach(order ->{
                String property  = StringUtils.trimToEmpty(order.getProperty());
                switch (property) {
                    case "ma_diem":
                        sb.append(" d.ma_diem ").append(getOrderBy(order.isAscending())).append(",");
                        break;
                }
            });
            sb.deleteCharAt(sb.length() -1 );
        }else {
            sb.append(" order by d.ma_diem ");
        }
        searchAndCountTotal(dto, sb.toString(), parameter, DiemDTO.class);
    }

    @Override
    public void searchDiemProfile(DiemSearchDTO dto, Integer idThe) {
        log.info("Start dao searchDiemProfile with :{} and idTHe: {}",dto,idThe);
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
        sb.append(" as(select u.id idUser,");
        sb.append(" u.name, ");
        sb.append("  l.id as idLop,");
        sb.append(" l.tenlop");
        sb.append(" from users u ");
        sb.append(" left join user_lop_mapper ulm on ulm.id_user = u.id");
        sb.append(" left join lop l on l.id = ulm.id_lop");
        sb.append(" where 1 = 1   ");
        sb.append(" and  u.ma_the =" +idThe +")");
        sb.append(" select d.id,");
        sb.append(" d.ma_diem as maDiem,");
        sb.append(" d.diemmieng as diemMieng,");
        sb.append(" d.diem15p as diem15p,");
        sb.append(" d.diem90p as diem90p,");
        sb.append(" d.diemtb as diemTB,");
        sb.append(" l.id as idLop,");
        sb.append(" l.tenlop as tenLop,");
        sb.append(" l.kip_day as kipDay,");
        sb.append(" t.ma_the as maThe,");
        sb.append(" u.id as idUser,");
        sb.append(" u.name as userName,");
        sb.append(" u.ngaysinh as ngaySinh, ");
        sb.append(" mh.tenmonhoc as tenMonHoc ");
        sb.append(" from diem d ");
        sb.append(" left join users_diem_map udm on udm.id_diem = d.id");
        sb.append(" left join users u on u.id = udm.id_user");
        sb.append(" left join info_gv igv on igv.idUser = u.id");
        sb.append(" left join user_lop_mapper ulm on ulm.id_user = u.id");
        sb.append(" left join lop l on l.id = ulm.id_lop");
        sb.append(" left join monhoc mh on mh.id = l.ma_monhoc");
        sb.append(" left join the t on t.id = u.ma_the");
        sb.append(" where 1=1 and u.is_teacher =0");
        if (StringUtils.isNotBlank(dto.getKipDay())){
            sb.append(" and l.kip_day like :p_kipDay");
            params.put("p_kipDay","%" + dto.getKipDay().trim() +"%");
        }
        if (StringUtils.isNotBlank(dto.getTenLop())){
            sb.append(" and l.tenlop like :p_tenLop");
            params.put("p_tenLop","%" + dto.getTenLop().trim() +"%");
        }
        sb.append(" order by t.ma_the");
        searchAndCountTotal(dto,sb.toString(),params,DiemSearchDTO.class);
    }
}
