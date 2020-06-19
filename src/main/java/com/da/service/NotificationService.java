package com.da.service;

import com.da.dto.NotificationDTO;
import com.da.model.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> getAll();

    List<Notification> getAllNeedRead();

    boolean isUnRead();

    void deleteAll();

    List<NotificationDTO> getAllDetail();

    boolean isRead();

    void readWithIdBV(Integer idBV);
}
