package com.da.dao;

import com.da.dto.NotificationDTO;

import java.io.Serializable;
import java.util.List;

public interface NotificationDAO extends Serializable, BaseDAO {
    List<NotificationDTO> getAllDetail(Integer idBV);
}
