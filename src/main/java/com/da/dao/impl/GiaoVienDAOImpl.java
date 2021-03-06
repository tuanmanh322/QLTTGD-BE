package com.da.dao.impl;

import com.da.dao.GiaoVienDAO;
import com.da.dto.GiaoVienDTO;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class GiaoVienDAOImpl extends AbstractDAO implements GiaoVienDAO {
    private final Logger log = LoggerFactory.getLogger(GiaoVienDAOImpl.class);

    public void searchGiaoVien(GiaoVienDTO dto) {
        log.info("Start dao searchGV with :{}", dto);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> parameter = new HashMap<>();
        sb.append(" select distinct u.id,");
        sb.append(" u.id_user as maGiaoVien,");
        sb.append(" u.name as Name ,");
        sb.append(" u.gioitinh as sex,");
        sb.append(" u.ngaysinh as NgaySinh, ");
        sb.append(" u.socmt as socmt, ");
        sb.append(" u.sodt as sodt, ");
        sb.append(" l.id as idLop, ");
        sb.append(" l.tenlop as tenLop, ");
        sb.append(" l.kip_day as kipDay,");
        sb.append(" l.siso as siso,");
        sb.append(" l.ma_lop as maLop,");
        sb.append(" u.ma_the as maThe,");
        sb.append(" u.luongcoban as luongcoban");
        sb.append(" from users as u ");
        sb.append(" left join user_lop_mapper as ulm on ulm.id_user = u.id and ulm.trangthai = 1 and ulm.is_teach = 1 ");
        sb.append(" left join lop as l on l.id = ulm.id_lop");
        sb.append(" where 1=1 and u.is_teacher = 1");
        if (StringUtils.isNotBlank(dto.getUsername())) {
            sb.append(" and u.name like :p_name ");
            parameter.put("p_name", "%" + dto.getUsername().trim() + "%");
        }
        if (StringUtils.isNotBlank(dto.getMaGiaoVien())){
            sb.append(" and u.id_user like :p_maGV ");
            parameter.put("p_maGV", "%" + dto.getMaGiaoVien().trim() + "%");
        }
        if (StringUtils.isNotBlank(dto.getTenLop())) {
            sb.append(" and l.tenlop like :p_tenlop ");
            parameter.put("p_tenlop", "%" + dto.getTenLop().trim() + "%");
        }
        if (dto.getOrders() != null && !dto.getOrders().isEmpty()) {
            sb.append(" order by ");
            dto.getOrders().forEach(order -> {
                String property = StringUtils.trimToEmpty(order.getProperty());
                switch (property) {
                    case "id_user":
                        sb.append(" u.id_user ").append(getOrderBy(order.isAscending())).append(",");
                        break;
                }
            });
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(" order by u.id_user ");
        }
        searchAndCountTotal(dto, sb.toString(), parameter, GiaoVienDTO.class);
    }
}
