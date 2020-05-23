package com.da.controller;

import com.da.dto.CheckInDTO;
import com.da.dto.HocSinhDTO;
import com.da.exception.ResultException;
import com.da.service.CheckInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/checkin")
@Slf4j
public class CheckInController {
    private final CheckInService checkInService ;

    public CheckInController(CheckInService checkInService) {
        this.checkInService = checkInService;
    }


    public ResponseEntity<Void> add(@RequestBody CheckInDTO dto) throws ResultException {
        log.info(" start rest to add lop hoc with :{}", dto);
        checkInService.add(dto);
        return ResponseEntity.ok().build();
    }
}
