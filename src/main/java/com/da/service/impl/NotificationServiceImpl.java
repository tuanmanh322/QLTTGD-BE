package com.da.service.impl;

import com.da.dao.NotificationDAO;
import com.da.dto.NotificationDTO;
import com.da.model.Baiviet;
import com.da.model.Notification;
import com.da.repository.BaivietRepository;
import com.da.repository.NotificationRepository;
import com.da.security.SecurityUtils;
import com.da.service.NotificationService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {
    private final Logger log = LoggerFactory.getLogger(NotificationServiceImpl.class);

    private final NotificationRepository notificationRepository;

    private final ModelMapper modelMapper;

    private final NotificationDAO notificationDAO;

    private final BaivietRepository baivietRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository, ModelMapper modelMapper, NotificationDAO notificationDAO, BaivietRepository baivietRepository) {
        this.notificationRepository = notificationRepository;
        this.modelMapper = modelMapper;
        this.notificationDAO = notificationDAO;
        this.baivietRepository = baivietRepository;
    }

    @Override
    public List<Notification> getAll() {
        log.info("start service to getAll notification");
        List<Notification> notificationList = notificationRepository.getAllByIdThe(SecurityUtils.getCurrentUserIdLogin());
        for (Notification notification : notificationList) {
            notification.setRead(0);
        }
        notificationRepository.saveAll(notificationList);
        return notificationList;
    }

    @Override
    public List<Notification> getAllNeedRead() {
        log.info("start service to getAllNeedRead notification");
        List<Notification> result = new ArrayList<>();
        List<Baiviet> baiviet = baivietRepository.getListBVByIdUser(SecurityUtils.getCurrentUserIdLogin());
        if (!baiviet.isEmpty()) {
            baiviet.stream().map(bv -> {
            List<Notification> notifications = notificationRepository.getAllNeedReadByIdThe(bv.getId());
            result.addAll(notifications);
            return bv;
            }).collect(Collectors.toList());
            return result;
        }
        return null;
    }

    @Override
    public boolean isUnRead() {
        log.info("start service to isUnRead notification");
        List<Notification> notifications = notificationRepository.isUnReadShowAll(SecurityUtils.getCurrentUserIdLogin(), 0);
        if (notifications.size() != 0) {
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
        List<NotificationDTO> result = new ArrayList<>();
        List<Baiviet> baiviet = baivietRepository.getListBVByIdUser(SecurityUtils.getCurrentUserIdLogin());
        if (!baiviet.isEmpty()) {
            baiviet.stream().map(bv -> {
                List<NotificationDTO> notifications = notificationDAO.getAllDetail(bv.getId());
                result.addAll(notifications);
                return bv;
            }).collect(Collectors.toList());
            return result;
        }
        return null;
    }

    @Override
    public boolean isRead() {
        log.info("start service to isUnRead notification");
        List<Notification> result = new ArrayList<>();
        List<Baiviet> baiviet = baivietRepository.getListBVByIdUser(SecurityUtils.getCurrentUserIdLogin());
        if (!baiviet.isEmpty()) {
            baiviet.stream().map(bv -> {
                List<Notification> notifications = notificationRepository.isUnReadShowAll(bv.getId(), 0);
                result.addAll(notifications);
                return bv;
            }).collect(Collectors.toList());
             if (result.size() != 0) {
                 for (Notification notification : result) {
                     notification.setRead(1);
                     notificationRepository.saveAll(result);
                 }
                 return true;
             }
        }
        return false;
    }

    @Override
    public void readWithIdBV(Integer idBV) {
        log.info("start service to readWithIdBV notification");

    }

    @Override
    public boolean checkAlreadyLike(Integer idBV) {
        log.info("start service to checkAlreadyLike notification");
        List<Notification> notification = notificationRepository.checkAlreadyLike(SecurityUtils.getCurrentUserIdLogin(), idBV);
        return notification.size() == 1;
    }

    @Override
    public boolean checkAlreadyDisLike(Integer idBV) {
        log.info("start service to checkAlreadyDisLike notification");
        List<Notification> notification = notificationRepository.checkAlreadyDisLike(SecurityUtils.getCurrentUserIdLogin(), idBV);
        return notification.size() == 1;
    }
}
