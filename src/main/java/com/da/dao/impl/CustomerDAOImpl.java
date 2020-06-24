package com.da.dao.impl;

import com.da.dao.CustomerDAO;
import com.da.dto.CustomerDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class CustomerDAOImpl extends AbstractDAO implements CustomerDAO {
    private final Logger log = LoggerFactory.getLogger(CustomerDAOImpl.class);

    @Override
    public void searchCustomer(CustomerDTO customerDTO) {
        log.info(" start dao to searchCustomer with :{}",customerDTO);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        sb.append(" select t.id , ");
        sb.append(" t.ma_the ,");
        sb.append(" t.ngaycap  ,");
        sb.append(" t.trangthai ,");
        sb.append(" u.name  ,");
        sb.append(" u.gioitinh  ,");
        sb.append(" u.email   ,");
        sb.append(" u.ngaysinh ");
        sb.append(" from the as t ");
        sb.append(" left users as u on u.ma_the = t.id");
        sb.append(" where 1 = 1");
        sb.append(" and t.id_role = 4");
        if (StringUtils.isNotBlank(customerDTO.getEmail())) {
            sb.append(" and u.email =:p_email");
            params.put("p_email",customerDTO.getEmail().trim().replace("\\", "\\\\")
                    .replaceAll("%", "\\%")
                    .replaceAll("_", "\\_"));
        }
        if (StringUtils.isNotBlank(customerDTO.getUsername())){
            sb.append(" and u.name =:p_name");
            params.put("p_name",customerDTO.getUsername().trim().replace("\\", "\\\\")
                    .replaceAll("%", "\\%")
                    .replaceAll("_", "\\_"));
        }

        sb.append(" order by t.ngaycap");

        searchAndCountTotal(customerDTO, sb.toString(), params, CustomerDTO.class);
    }
}
