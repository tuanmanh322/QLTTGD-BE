package com.da.dao.impl;

import com.da.dao.NotificationDAO;
import com.da.dto.NotificationDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NotificationDAOImpl extends AbstractDAO implements NotificationDAO {
    @Override
    public List<NotificationDTO> getAllDetail(Integer idBV) {
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> map = new HashMap<>();
        sb.append(" select  no.id ,");
        sb.append(" no.id_the as idThe,");
        sb.append(" no.id_action as idAction,");
        sb.append(" no.is_read as isRead,");
        sb.append(" no.message,");
        sb.append(" no.created_date as createdDate,");
        sb.append(" no.id_baiviet as idBaiViet,");
        sb.append(" bv.title as titleBV,");
        sb.append(" u.name as userName");
        sb.append(" from notification as no");
        sb.append(" left join baiviet as bv on bv.id = no.id_baiviet");
        sb.append(" left join users as u on u.ma_the = no.id_the ");
        sb.append(" where 1 = 1 ");
        if (idBV != null) {
            sb.append(" and no.id_baiviet =:p_id_baiviet");
            map.put("p_id_baiviet", idBV);
        }
        sb.append(" order by no.created_date");
        return namedParameterJdbcTemplate().query(sb.toString(), map, new BeanPropertyRowMapper<>(NotificationDTO.class));
    }
}
