package com.da.controller;

import com.da.dto.MonHocDTO;
import com.da.dto.MonHocSearchDTO;
import com.da.model.Monhoc;
import com.da.service.MonHocService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mon-hoc")
public class MonHocController {
    private final Logger log = LoggerFactory.getLogger(MonHocController.class);

    private final MonHocService monHocService;

    public MonHocController(MonHocService monHocService) {
        this.monHocService = monHocService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Monhoc>> getAll() {
        log.info(" start service to get All mon hoc");
        return new ResponseEntity<>(monHocService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<MonHocSearchDTO> SEARCH(@RequestBody MonHocSearchDTO dto) {
        log.info(" start service to get MonHocSearchDTO mon hoc with : {}", dto);
        monHocService.searchMH(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody MonHocDTO monHocDTO) {
        monHocService.add(monHocDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> edit(@RequestBody MonHocDTO monHocDTO) {
        monHocService.edit(monHocDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idMH}")
    public ResponseEntity<Void> delete(@PathVariable("idMH") Integer idMH) {
        monHocService.delete(idMH);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/check-mamh")
    public ResponseEntity<Boolean> checkMaMh(@RequestParam("maMH") String maMH){
        return new ResponseEntity<>(monHocService.checkExítMaMH(maMH),HttpStatus.OK);
    }

    @GetMapping("/check-tenmh")
    public ResponseEntity<Boolean> checktenmh(@RequestParam("tenMH") String tenMH){
        return new ResponseEntity<>(monHocService.checkExistName(tenMH),HttpStatus.OK);
    }
}
