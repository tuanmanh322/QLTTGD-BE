package com.da.dao.impl;

import com.da.dao.HocSinhDao;
import com.da.dto.HocSinhDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class HocSinhDAOImpl extends AbstractDAO implements HocSinhDao {
    private final Logger log = LoggerFactory.getLogger(HocSinhDAOImpl.class);

    public void searchHocSinh(HocSinhDTO dto){
        log.info("Start dao searchHS with :{}",dto);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> parameter = new HashMap<>();
        sb.append(" select u.id,");
        sb.append(" u.id_user as maHocSinh,");
        sb.append(" u.name as Name ,");
        sb.append(" u.gioitinh as GioiTinh,");
        sb.append(" u.ngaysinh as NgaySinh, ");
        sb.append(" u.socmt as socmt, ");
        sb.append(" u.sodt as sodt, ");
        sb.append(" u.ma_lop as maLop, ");
        sb.append(" l.tenlop as tenLop, ");
        sb.append(" u.ma_the as maThe, ");
        sb.append(" from users as u ");
        sb.append(" left join Lop as l on l.ma_lop = u.ma_lop where 1=1");
        if (StringUtils.isNotBlank(dto.getName())) {
            sb.append(" and u.name like :p_name ");
            parameter.put("p_name", "%" + dto.getName().trim() + "%");
        }
        if (StringUtils.isNotBlank(dto.getTenLop())) {
            sb.append(" and l.tenlop like :p_tenlop ");
            parameter.put("p_tenlop", "%" + dto.getTenLop().trim() + "%");
        }
        if (dto.getOrderDTOS() != null && !dto.getOrderDTOS().isEmpty()) {
            sb.append(" order by ");
            dto.getOrderDTOS().forEach(order ->{
                String property  = StringUtils.trimToEmpty(order.getProperty());
                switch (property) {
                    case "id_user":
                        sb.append(" u.id_user ").append(getOrderBy(order.isAscending())).append(",");
                        break;
                }
            });
            sb.deleteCharAt(sb.length() -1 );
        }else {
            sb.append(" order by u.id_user ");
        }
        searchAndCountTotal(dto, sb.toString(), parameter, HocSinhDTO.class);
    }

}
