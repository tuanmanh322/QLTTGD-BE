package com.da.controller;

import com.da.common.CommonResult;
import com.da.dto.GiaoVienDTO;
import com.da.dto.HocSinhDTO;
import com.da.exception.ResultException;
import com.da.service.GiaoVienService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/giao-vien")
@Slf4j
public class GiaoVienController {
    private final GiaoVienService giaoVienService;

    public GiaoVienController(GiaoVienService giaoVienService) {
        this.giaoVienService = giaoVienService;
    }


    @PostMapping("/search")
    public ResponseEntity<GiaoVienDTO> searchAndGetAll(@RequestBody GiaoVienDTO dto) {
        log.info(" start rest to searchAndGetAll with :{}", dto);
        giaoVienService.searchGiaoVien(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GiaoVienDTO> findByID(@PathVariable("id") Integer id) {
        log.info("start rest to findByID WITH ID:{}", id);
        GiaoVienDTO dto = giaoVienService.findById(id);
        return new ResponseEntity<GiaoVienDTO>(dto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CommonResult> add(@RequestBody GiaoVienDTO dto) throws ResultException {
        log.info(" start rest to add lop hoc with :{}", dto);
        return new ResponseEntity<>( giaoVienService.add(dto),HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> edit(@RequestBody GiaoVienDTO dto) throws ResultException {
        log.info(" start rest to edit lop hoc with :{}", dto);
        giaoVienService.update(dto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id")Integer id)throws ResultException{
        log.info(" start service to delete with :{}",id);
        giaoVienService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/count-all-gv")
    public ResponseEntity<Integer> countAllGV() {
        return new ResponseEntity<>(giaoVienService.countGVALL(),HttpStatus.OK);
    }

    @GetMapping("/count-all-gv-ac")
    public ResponseEntity<Integer> countAllGVAc() {
        return new ResponseEntity<>(giaoVienService.countGVActive(),HttpStatus.OK);
    }
}
