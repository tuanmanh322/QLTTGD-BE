package com.da.dao.impl;

import com.da.dao.ChuDeDAO;
import com.da.dto.ChuDeCountDTO;
import com.da.dto.ChuDeSearchDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ChuDeDAOImpl extends AbstractDAO implements ChuDeDAO {
    private final Logger log = LoggerFactory.getLogger(ChuDeDAOImpl.class);
    public void searchChuDe(ChuDeSearchDTO dto){
        log.info("Start dao searchChuDe with :{}",dto);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> parameter = new HashMap<>();
        sb.append(" select distinct cd.id ," );
        sb.append(" cd.ma_chude as maChude,");
        sb.append(" cd.tenchude as tenChude,");
        sb.append(" cd.noidung as noiDung,");
        sb.append(" hm.tenhangmuc as tenHangmuc");
        sb.append(" from CHUDE as cd");
        sb.append(" left join HANGMUC as hm on cd.id_hangmuc = hm.id");
        sb.append(" where 1=1");
        if (StringUtils.isNotBlank(dto.getTenchude())) {
            sb.append(" and cd.tenchude like :p_tenchude ");
            parameter.put("p_tenchude", "%" + dto.getTenchude().trim() + "%");
        }
        if (StringUtils.isNotBlank(dto.getTenHangmuc())) {
            sb.append(" and hm.tenhangmuc like :p_tenhangmuc ");
            parameter.put("p_tenhangmuc", "%" + dto.getTenHangmuc().trim() + "%");
        }
        if (dto.getOrders() != null && !dto.getOrders().isEmpty()) {
            sb.append(" order by ");
            dto.getOrders().forEach(order ->{
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

    @Override
    public List<ChuDeCountDTO> getChuAndCount(Integer idHM) {
        log.info("Start dao getChuAndCount ");
        StringBuilder sb = new StringBuilder();
        sb.append(" select new ").append(ChuDeCountDTO.class.getName());
        sb.append(" ( cd.id,");
        sb.append(" cd.maChude as maChuDe,");
        sb.append(" cd.tenChude as tenChuDe,");
        sb.append(" count(bv.id) as baiVietCount )");
        sb.append(" from Chude as cd");
        sb.append(" left join Baiviet as bv");
        sb.append(" on (bv.ma_chude = cd.id or bv.id is  null)");
        sb.append(" left join Hangmuc as hm on hm.id = cd.idHangmuc or hm.id is null");
        sb.append(" where 1= 1");
        if (idHM != null){
            sb.append(" and hm.id=:p_hm");
        }
        sb.append("  group by cd.id, cd.maChude,cd.tenChude");
        TypedQuery<ChuDeCountDTO> query = getSession().createQuery(sb.toString(),ChuDeCountDTO.class);
        query.setParameter("p_hm",idHM);
        return query.getResultList();
    }

}
