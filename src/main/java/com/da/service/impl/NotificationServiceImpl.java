package com.da.service.impl;

import com.da.dao.NotificationDAO;
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

    private final NotificationDAO notificationDAO;

    public NotificationServiceImpl(NotificationRepository notificationRepository, ModelMapper modelMapper, NotificationDAO notificationDAO) {
        this.notificationRepository = notificationRepository;
        this.modelMapper = modelMapper;
        this.notificationDAO = notificationDAO;
    }

    @Override
    public List<Notification> getAll() {
        log.info("start service to getAll notification");
        List<Notification> notificationList = notificationRepository.getAllByIdThe(SecurityUtils.getCurrentUserIdLogin());
        for (Notification notification : notificationList){
            notification.setRead(0);
        }
        notificationRepository.saveAll(notificationList);
        return notificationList;
    }

    @Override
    public List<Notification> getAllNeedRead() {
        log.info("start service to getAllNeedRead notification");
        return notificationRepository.getAllNeedReadByIdThe(SecurityUtils.getCurrentUserIdLogin());
    }

    @Override
    public boolean isUnRead() {
        log.info("start service to isUnRead notification");
        List<Notification> notifications = notificationRepository.isUnReadShowAll(SecurityUtils.getCurrentUserIdLogin(),0);
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

    @Override
    public List<NotificationDTO> getAllDetail() {
        log.info("start service to getAllDetail notification");

        return notificationDAO.getAllDetail(SecurityUtils.getCurrentUserIdLogin());
    }

    @Override
    public boolean isRead() {
        log.info("start service to isUnRead notification");
        List<Notification> notifications = notificationRepository.isUnReadShowAll(SecurityUtils.getCurrentUserIdLogin(),0);
        if (notifications.size()!= 0){
            for (Notification notification : notifications){
                notification.setRead(1);
                notificationRepository.saveAll(notifications);
            }
            return true;
        }
        return false;
    }

    @Override
    public void readWithIdBV(Integer idBV) {
        log.info("start service to readWithIdBV notification");

    }
}
