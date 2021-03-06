package com.da.controller;

import com.da.dto.NotificationDTO;
import com.da.model.Notification;
import com.da.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/all-need")
    public ResponseEntity<List<Notification>> getAllNeedRead() {
        log.info("start rest to get all getAllNeedRead");
        return new ResponseEntity<>(notificationService.getAllNeedRead(), HttpStatus.OK);
    }

    @GetMapping("/clear-notification")
    public ResponseEntity<Void> deleteAll() {
        log.info("start rest to get all Notification");
        notificationService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all-detail")
    public ResponseEntity<List<NotificationDTO>> getAllDetail() {
        log.info("start rest to get all getAllDetail");
        return new ResponseEntity<>(notificationService.getAllDetail(), HttpStatus.OK);
    }

    @GetMapping("/read-all")
    public ResponseEntity<Boolean> readAll() {
        log.info("start rest to get all readAll");
        return new ResponseEntity<>(notificationService.isRead(), HttpStatus.OK);
    }

    @GetMapping("/already-like/{idBV}")
    public ResponseEntity<Boolean> checkAlreadyLike(@PathVariable("idBV") Integer idBV) {
        log.info("start rest to checkAlreadyLike with idBV: {}",idBV);
        return new ResponseEntity<>(notificationService.checkAlreadyLike(idBV), HttpStatus.OK);
    }
    @GetMapping("/already-dislike/{idBV}")
    public ResponseEntity<Boolean> checkAlreadyDislike(@PathVariable("idBV") Integer idBV) {
        log.info("start rest to checkAlreadyDislike with idBV: {}",idBV);
        return new ResponseEntity<>(notificationService.checkAlreadyDisLike(idBV), HttpStatus.OK);
    }

//    @GetMapping("/is-read-bv/{idBV}")
    public ResponseEntity<Void> isReadBV(@PathVariable("idBV")Integer idBV){
        notificationService.readWithIdBV(idBV);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
