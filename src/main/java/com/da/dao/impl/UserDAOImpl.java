package com.da.dao.impl;

import com.da.dao.UserDAO;
import com.da.dto.UserSearchDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDAOImpl extends AbstractDAO implements UserDAO {
    private final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);


    @Override
    public void searchUser(UserSearchDTO userSearchDTO) {
        log.info("start DAO to searchUser with :{}", userSearchDTO);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> param = new HashMap<>();
        sb.append(" select distinct t.id as idThe,");
        sb.append(" t.ma_the as maThe,");
        sb.append(" t.ngaycap as createDate,");
        sb.append(" t.id_role as idRole,");
        sb.append(" t.trangthai as active,");
        sb.append(" u.name as userName,");
        sb.append(" u.email as emailUser,");
        sb.append(" u.gioitinh as sex,");
        sb.append(" u.luongcoban as luongcoban,");
        sb.append(" u.is_teacher as isTeacher,");
        sb.append(" u.sodt as sodt,");
        sb.append(" u.quequan as quequan");
        sb.append(" from the as t ");
        sb.append(" left join users as u on t.id = u.ma_the");
        sb.append(" where 1 = 1");
        if (userSearchDTO.getIdRole() != null) {
            sb.append(" and t.id_role=:p_idRole");
            param.put("p_idRole", userSearchDTO.getIdRole());
        }
        if (StringUtils.isNotBlank(userSearchDTO.getUserName())) {
            sb.append(" and u.name like :p_userName");
            param.put("p_userName", "%" + userSearchDTO.getUserName().trim() + "%");
        }
        if (StringUtils.isNotBlank(userSearchDTO.getActive())){
            sb.append(" and t.trangthai=:p_tt");
            param.put("p_tt", userSearchDTO.getActive());
        }
        sb.append(" order by u.name");
        searchAndCountTotal(userSearchDTO, sb.toString(), param, UserSearchDTO.class);
    }
}
