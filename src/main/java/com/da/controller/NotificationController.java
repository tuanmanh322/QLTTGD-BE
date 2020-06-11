package com.da.controller;

import com.da.model.Notification;
import com.da.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
    private final Logger log = LoggerFactory.getLogger(NotificationController.class);

    private final NotificationService notificationService;


    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Notification>> getAll() {
        log.info("start rest to get all Notification");
        return new ResponseEntity<>(notificationService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/un-read")
    public ResponseEntity<Boolean> unRead() {
        log.info("start rest to get all Notification");
        return new ResponseEntity<>(notificationService.isUnRead(), HttpStatus.OK);
    }

    @GetMapping("/clear-notification")
    public ResponseEntity<Void> deleteAll() {
        log.info("start rest to get all Notification");
        notificationService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
