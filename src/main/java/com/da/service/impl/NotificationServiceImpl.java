package com.da.service.impl;

import com.da.dto.NotificationDTO;
import com.da.model.Notification;
import com.da.repository.NotificationRepository;
import com.da.security.SecurityUtils;
import com.da.service.NotificationService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {
    private final Logger log =LoggerFactory.getLogger(NotificationServiceImpl.class);

    private final NotificationRepository notificationRepository;

    private final ModelMapper modelMapper;

    public NotificationServiceImpl(NotificationRepository notificationRepository, ModelMapper modelMapper) {
        this.notificationRepository = notificationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Notification> getAll() {
        log.info("start service to getAll notification");
        List<Notification> notificationList = notificationRepository.getAllByIdThe(SecurityUtils.getCurrentUserIdLogin());
        for (Notification notification : notificationList){
            notification.setRead(true);
        }
        notificationRepository.saveAll(notificationList);
        return notificationList;
    }

    @Override
    public boolean isUnRead() {
        log.info("start service to isUnRead notification");
        List<Notification> notifications = notificationRepository.isUnReadShowAll(SecurityUtils.getCurrentUserIdLogin(),false);
        if (notifications.size()!= 0){
            return true;
        }
        return false;
    }

    @Override
    public void deleteAll() {
        log.info("start service to deleteAll notification");
        List<Notification> notificationList = notificationRepository.getAllByIdThe(SecurityUtils.getCurrentUserIdLogin());
        notificationRepository.deleteAll(notificationList);
    }
}
