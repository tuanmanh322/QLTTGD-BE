package com.da.controller;

import com.da.dto.ChuDeCountDTO;
import com.da.dto.ChuDeDTO;
import com.da.dto.ChuDeSearchDTO;
import com.da.exception.ResultException;
import com.da.service.ChuDeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chu-de")
@Slf4j
public class ChuDeController {
    private ChuDeService chuDeService;

    public ChuDeController(ChuDeService chuDeService) {
        super();
        this.chuDeService = chuDeService;
    }

    @PostMapping("/search")
    public ResponseEntity<ChuDeSearchDTO> searchAndGetAll(@RequestBody ChuDeSearchDTO dto) {
        log.info(" start rest to searchAndGetAll with :{}", dto);
        chuDeService.searchChuDe(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChuDeDTO> findByID(@PathVariable("id") Integer id) {
        log.info("start rest to findByID WITH ID:{}", id);
        ChuDeDTO dto = chuDeService.findById(id);
        return new ResponseEntity<ChuDeDTO>(dto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody ChuDeDTO dto) throws ResultException {
        log.info(" start rest to add lop hoc with :{}", dto);
        chuDeService.add(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> edit(@RequestBody ChuDeDTO dto) throws ResultException {
        log.info(" start rest to edit lop hoc with :{}", dto);
        chuDeService.update(dto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id")Integer id)throws ResultException{
        log.info(" start service to delete with :{}",id);
        chuDeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-count")
    public ResponseEntity<List<ChuDeCountDTO>> getChuDeAndCount(){
        log.info(" start service to getChuDeAndCount");
        return new ResponseEntity<>(chuDeService.getChuDeAndCount(),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ChuDeDTO>> getAll(){
        log.info(" start service to getAll");
        return new ResponseEntity<>(chuDeService.getAllCD(),HttpStatus.OK);
    }
}
