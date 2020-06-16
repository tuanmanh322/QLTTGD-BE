package com.da.controller;

import com.da.dto.CheckInDTO;
import com.da.exception.ResultException;
import com.da.service.CheckInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/checkin")
@Slf4j
public class CheckInController {
    private final CheckInService checkInService;

    public CheckInController(CheckInService checkInService) {
        this.checkInService = checkInService;
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody CheckInDTO dto) throws ResultException {
        log.info(" start rest to add lop hoc with :{}", dto);
        checkInService.add(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search-profile")
    public ResponseEntity<CheckInDTO> searchCheckInByProfile(@RequestBody CheckInDTO checkInDTO) {
        log.info(" start rest to searchCheckInByProfile with {}", checkInDTO);
        checkInService.searchCheckInByProfile(checkInDTO);
        return new ResponseEntity<>(checkInDTO, HttpStatus.OK);
    }
}
