package com.da.dao.impl;

import com.da.dao.ContactDAO;
import com.da.dto.ContactSearchDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ContactDAOImpl extends AbstractDAO implements ContactDAO {
    @Override
    public void searchContact(ContactSearchDTO contactSearchDTO) {
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> param = new HashMap<>();
        sb.append(" select c.id ,");
        sb.append(" c.username,");
        sb.append(" c.email,");
        sb.append(" c.sdt,");
        sb.append(" c.status");
        sb.append(" from contact as c");
        sb.append(" where 1 = 1 ");
        sb.append(" and 1 = 1");

        if (StringUtils.isNotBlank(contactSearchDTO.getUsername())) {
            sb.append(" and c.username like :p_username");
            param.put("p_username", "%" + contactSearchDTO.getUsername().trim() + "%");
        }
        if (StringUtils.isNotBlank(contactSearchDTO.getEmail())) {
            sb.append(" and c.email like :p_email");
            param.put("p_email", "%" + contactSearchDTO.getEmail().trim() + "%");
        }

        if (StringUtils.isNotBlank(contactSearchDTO.getSdt())) {
            sb.append(" and c.sdt like :p_sdt");
            param.put("p_sdt", "%" + contactSearchDTO.getSdt().trim() + "%");
        }

        searchAndCountTotal(contactSearchDTO,sb.toString(), param, ContactSearchDTO.class);
    }
}
