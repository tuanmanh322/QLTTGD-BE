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
        sb.append(" select distinct u.id,");
        sb.append(" u.id_user as maHocSinh,");
        sb.append(" u.name as hocsinhName ,");
        sb.append(" u.gioitinh as GioiTinh,");
        sb.append(" u.ngaysinh as NgaySinh, ");
        sb.append(" u.socmt as socmt, ");
        sb.append(" u.sodt as sodt, ");
        sb.append(" u.ma_lop as maLop, ");
        sb.append(" l.tenlop as tenLop, ");
        sb.append(" l.thoigianbatdau as thoiGianBatDau, ");
        sb.append(" u.ma_the as maThe, ");
        sb.append(" t.ma_the as soThe");
        sb.append(" from users as u ");
        sb.append(" left join the as t on t.id = u.ma_the ");
        sb.append(" left join user_lop_mapper as ulm on u.id = ulm.id_user ");
        sb.append(" left join Lop as l on l.id = ulm.id_lop ");
        sb.append(" where 1=1 ");
        sb.append(" and t.id_role = 3 ");
        sb.append(" and u.is_teacher = 0");
        if (StringUtils.isNotBlank(dto.getHocsinhName())) {
            sb.append(" and u.name like :p_name ");
            parameter.put("p_name", "%" + dto.getHocsinhName().trim() + "%");
        }
        if (StringUtils.isNotBlank(dto.getMaHocSinh())) {
            sb.append(" and t.ma_the=:p_maHocS ");
            parameter.put("p_maHocS", "%" + dto.getMaHocSinh().trim() + "%");
        }
        if (StringUtils.isNotBlank(dto.getTenLop())) {
            sb.append(" and l.tenlop like :p_tenlp ");
            parameter.put("p_tenlp", "%" + dto.getTenLop().trim() + "%");
        }
        if (dto.getOrders() != null && !dto.getOrders().isEmpty()) {
            sb.append(" order by ");
            dto.getOrders().forEach(order ->{
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
