package com.da.controller;

import com.da.dto.BaiVietDTO;
import com.da.dto.BaiVietSearchDTO;
import com.da.exception.ResultException;
import com.da.service.BaiVietService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/baiviet")
@Slf4j
public class BaiVietController {
    private BaiVietService baiVietService;
    public BaiVietController(BaiVietService baiVietService){
        super();
        this.baiVietService= baiVietService;
    }
    @PostMapping("/search")
    public ResponseEntity<BaiVietSearchDTO> searchAndGetAll(@RequestBody BaiVietSearchDTO dto) {
        log.info(" start rest to searchAndGetAll with :{}", dto);
        baiVietService.searchBaiViet(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaiVietDTO> findByID(@PathVariable("id") Integer id) {
        log.info("start rest to findByID WITH ID:{}", id);
        BaiVietDTO dto = baiVietService.findById(id);
        return new ResponseEntity<BaiVietDTO>(dto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody BaiVietDTO dto) throws ResultException {
        log.info(" start rest to add bai viet with :{}", dto);
        baiVietService.add(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> edit(@RequestBody BaiVietDTO dto) throws ResultException {
        log.info(" start rest to edit bai viet with :{}", dto);
        baiVietService.update(dto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id")Integer id)throws ResultException{
        log.info(" start service to delete with :{}",id);
        baiVietService.delete(id);
        return ResponseEntity.ok().build();
    }
}
