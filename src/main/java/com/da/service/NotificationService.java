package com.da.service;

import com.da.model.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> getAll();

    boolean isUnRead();

    void deleteAll();
}
