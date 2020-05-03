package com.da.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.Order;

import com.da.dto.BaseSearch;
import com.da.dto.ChuDeSearchDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.da.dao.ChuDeDAO;
import com.da.dto.ChuDeSearchDTO;
@Repository
public class ChuDeDAOImpl extends AbstractDAO implements ChuDeDAO {
    private final Logger log = LoggerFactory.getLogger(ChuDeDAOImpl.class);
    public void searchChuDe(ChuDeSearchDTO dto){
        log.info("Start dao searchChuDe with :{}",dto);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> parameter = new HashMap<>();
        sb.append(" select  cd.id ," );
        sb.append(" cd.ma_chude as maChude,");
        sb.append(" cd.tenchude as tenChude,");
        sb.append(" cd.noidung as noiDung,");
        sb.append(" hm.tenhangmuc as tenHangmuc");
        sb.append(" from CHUDE as cd");
        sb.append(" left join HANGMUC as hm on cd.ma_hangmuc = hn.ma_hangmuc");
        sb.append(" where 1=1");
        if (StringUtils.isNotBlank(dto.getTenchude())) {
            sb.append(" and cd.tenchude like :p_tenchude ");
            parameter.put("p_tenchude ", "%" + dto.getTenchude().trim() + "%");
        }
        if (dto.getOrderDTOS() != null && !dto.getOrderDTOS().isEmpty()) {
            sb.append(" order by ");
            dto.getOrderDTOS().forEach(order ->{
                String property  = StringUtils.trimToEmpty(order.getProperty());
                switch (property) {
                    case "tenchude":
                        sb.append(" cd.tenchude ").append(getOrderBy(order.isAscending())).append(",");
                        break;
                }
            });
            sb.deleteCharAt(sb.length() -1 );
        }else {
            sb.append(" order by cd.tenchude  ");
        }
        searchAndCountTotal(dto, sb.toString(), parameter, ChuDeSearchDTO.class);
    }

}
