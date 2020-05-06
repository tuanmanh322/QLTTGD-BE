package com.da.dao.impl;

import com.da.dao.CommentDAO;
import com.da.dto.CommentSearchDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

import java.util.Map;

@Repository
public class CommentDAOImpl extends AbstractDAO implements CommentDAO {
    private final Logger log = LoggerFactory.getLogger(CommentDAOImpl.class);
    @Override
    public void searchComment(CommentSearchDTO dto) {
        log.info("Start dao searchComment with :{}",dto);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> parameter = new HashMap<>();
        sb.append(" select  cm.id ," );
        sb.append(" cm.ma_comment as maComment,");
        sb.append(" cm.noidung as noiDung,");
        sb.append(" cm.luotthich as luotThich,");
        sb.append(" cm.luotkhongthich as luotKhongthich,");
        sb.append(" bv.ten_baiviet as tenBaiviet,");
        sb.append(" from COMMENT as cm");
        sb.append(" left join BAIVIET as bv on cm.ma_baiviet = bv.ma_baiviet");
        sb.append(" where 1=1");
        if (StringUtils.isNotBlank(dto.getMaComment())) {
            sb.append(" and cm.maComment like :p_maComment");
            parameter.put("p_maComment", "%" + dto.getMaComment().trim() + "%");
        }
        if (dto.getOrderDTOS() != null && !dto.getOrderDTOS().isEmpty()) {
            sb.append(" order by ");
            dto.getOrderDTOS().forEach(order ->{
                String property  = StringUtils.trimToEmpty(order.getProperty());
                switch (property) {
                    case "maComment":
                        sb.append(" cm.maComment ").append(getOrderBy(order.isAscending())).append(",");
                        break;
                }
            });
            sb.deleteCharAt(sb.length() -1 );
        }else {
            sb.append(" order by cm.maComment ");
        }
        searchAndCountTotal(dto, sb.toString(), parameter, CommentSearchDTO.class);
    }

}
