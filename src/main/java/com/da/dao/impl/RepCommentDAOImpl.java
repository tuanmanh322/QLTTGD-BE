package com.da.dao.impl;

import com.da.dao.RepCommentDAO;
import com.da.dto.RepCommentSearchDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RepCommentDAOImpl extends AbstractDAO implements RepCommentDAO {
    private final Logger log = LoggerFactory.getLogger(RepCommentDAOImpl.class);
@Override
    public void searchRepComment(RepCommentSearchDTO dto) {
        log.info("Start dao searchRepComment with :{}",dto);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> parameter = new HashMap<>();
        sb.append(" select  rcm.id ," );
        sb.append(" rcm.ma_repcomment as maRepcomment,");
        sb.append(" rcm.noidung as noiDung,");
        sb.append(" rcm.luotthich as luotThich,");
        sb.append(" rcm.luotkhongthich as luotKhongthich,");
        sb.append(" cm.noidung as noiDung,");
        sb.append(" from REPCOMMENT as rcm");
        sb.append(" left join COMMENT as cm on rcm.ma_comment  = cm.ma_comment ");
        sb.append(" where 1=1");
        if (StringUtils.isNotBlank(dto.getMaRepcomment())) {
            sb.append(" and rcm.maRepomment like :p_maRepomment");
            parameter.put("p_maRepomment", "%" + dto.getMaRepcomment().trim() + "%");
        }
        if (dto.getOrders() != null && !dto.getOrders().isEmpty()) {
            sb.append(" order by ");
            dto.getOrders().forEach(order ->{
                String property  = StringUtils.trimToEmpty(order.getProperty());
                switch (property) {
                    case "maRepomment":
                        sb.append(" rcm.maRepomment ").append(getOrderBy(order.isAscending())).append(",");
                        break;
                }
            });
            sb.deleteCharAt(sb.length() -1 );
        }else {
            sb.append(" order by rcm.maRepomment ");
        }
        searchAndCountTotal(dto, sb.toString(), parameter, RepCommentSearchDTO.class);
    }

}
