package com.da.dao.impl;

import com.da.dao.CardDAO;
import com.da.dto.CardSearchDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CardDAOImpl extends AbstractDAO implements CardDAO {
    private final Logger log = LoggerFactory.getLogger(CardDAOImpl.class);
    public void searchCard(CardSearchDTO dto){
        log.info("Start dao searchCard with :{}",dto);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> parameter = new HashMap<>();
        sb.append(" select  cd.id ,cd.ma_the as maThe," );
        sb.append(" cd.ngaycap as ngayCap,");
        sb.append(" cd.trangthai as trangThai,");
        sb.append(" cd.password as passWord,");
        sb.append(" ro.name_role as nameRole,");
        sb.append(" from THE as cd");
        sb.append(" left join ROLE as ro on cd.id_role = ro.id_role ");
        sb.append(" where 1=1");
        if (StringUtils.isNotBlank(dto.getMaThe())) {
            sb.append(" and cd.maThe like :p_maThe ");
            parameter.put("p_maThe", "%" + dto.getMaThe().trim() + "%");
        }
        if (dto.getOrders() != null && !dto.getOrders().isEmpty()) {
            sb.append(" order by ");
            dto.getOrders().forEach(order ->{
                String property  = StringUtils.trimToEmpty(order.getProperty());
                switch (property) {
                    case "maThe":
                        sb.append(" cd.maThe").append(getOrderBy(order.isAscending())).append(",");
                        break;
                }
            });
            sb.deleteCharAt(sb.length() -1 );
        }else {
            sb.append(" order by cd.maThe  ");
        }
        searchAndCountTotal(dto, sb.toString(), parameter, CardSearchDTO.class);
    }
}
