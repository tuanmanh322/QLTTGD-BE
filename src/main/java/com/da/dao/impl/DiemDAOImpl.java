package com.da.dao.impl;

import com.da.dao.DiemDAO;
import com.da.dto.DiemDTO;
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
}
