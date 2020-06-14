package com.da.controller;

import com.da.model.Monhoc;
import com.da.service.MonHocService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mon-hoc")
public class MonHocController {
    private final Logger log =LoggerFactory.getLogger(MonHocController.class);

    private final MonHocService monHocService;

    public MonHocController(MonHocService monHocService) {
        this.monHocService = monHocService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Monhoc>> getAll(){
        log.info(" start service to get All mon hoc");
        return new ResponseEntity<>(monHocService.getAll(), HttpStatus.OK);
    }
}
