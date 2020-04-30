package com.da.controller;

import com.da.model.Ward;
import com.da.repository.WardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ward")
public class WardController {
    private final Logger log = LoggerFactory.getLogger(WardController.class);

    private final WardRepository wardRepository;

    public WardController(WardRepository wardRepository) {
        this.wardRepository = wardRepository;
    }

    @GetMapping
    public ResponseEntity<List<Ward>> getAll(){
        return new ResponseEntity<>(wardRepository.findAll(), HttpStatus.OK);
    }
}
