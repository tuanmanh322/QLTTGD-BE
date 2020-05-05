package com.da.controller;

import com.da.dto.HangMucDTO;
import com.da.dto.HangMucSearchDTO;
import com.da.exception.ResultException;
import com.da.service.HangMucService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/hang-muc")
@Slf4j
public class HangMucController {
    private HangMucService hangMucService;

    public HangMucController(HangMucService hangMucService ) {
        super();
        this.hangMucService = hangMucService;
    }
    @PostMapping("/search")
    public ResponseEntity<HangMucSearchDTO> searchAndGetAll(@RequestBody HangMucSearchDTO dto) {
        log.info(" start rest to searchAndGetAll with :{}", dto);
        hangMucService.searchHangMuc(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HangMucDTO> findByID(@PathVariable("id") Integer id) {
        log.info("start rest to findByID WITH ID:{}", id);
        HangMucDTO dto = hangMucService.findById(id);
        return new ResponseEntity<HangMucDTO>(dto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody HangMucDTO dto) throws ResultException {
        log.info(" start rest to add lop hoc with :{}", dto);
        hangMucService.add(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> edit(@RequestBody HangMucDTO dto) throws ResultException {
        log.info(" start rest to edit lop hoc with :{}", dto);
        hangMucService.update(dto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id")Integer id)throws ResultException{
        log.info(" start service to delete with :{}",id);
        hangMucService.delete(id);
        return ResponseEntity.ok().build();
    }
}
