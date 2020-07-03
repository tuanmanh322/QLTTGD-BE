package com.da.controller;

import com.da.dto.CheckInDTO;
import com.da.dto.CheckInDetailDTO;
import com.da.dto.NhatKySearchDTO;
import com.da.exception.ResultException;
import com.da.service.CheckInService;
import com.da.service.NhatKyCheckInService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkin")
@Slf4j
public class CheckInController {
    private final CheckInService checkInService;

    private final NhatKyCheckInService nhatKyCheckInService;

    public CheckInController(CheckInService checkInService, NhatKyCheckInService nhatKyCheckInService) {
        this.checkInService = checkInService;
        this.nhatKyCheckInService = nhatKyCheckInService;
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

    @PostMapping("/search-admin")
    public ResponseEntity<NhatKySearchDTO> searchCheckInByManager(@RequestBody NhatKySearchDTO dto) {
        log.info(" start rest to searchCheckInByManager with {}", dto);
        nhatKyCheckInService.searchNkAdmin(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/load-checkin/{idThe}")
    public ResponseEntity<CheckInDetailDTO> loadCheckIn(@PathVariable("idThe") Integer idThe) {
        log.info(" start rest to loadCheckIn with {}", idThe);
        return new ResponseEntity<>(checkInService.getCheckinByIdThe(idThe), HttpStatus.OK);
    }
}
