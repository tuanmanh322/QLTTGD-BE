package com.da.controller;
import com.da.dto.BaiVietDTO;
import com.da.dto.BaiVietSearchDTO;
import com.da.dto.BaiVietTotalSearchDTO;
import com.da.exception.ResultException;
import org.springframework.http.ResponseEntity;
import com.da.service.BaiVietService;
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

import java.util.List;

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
    @PostMapping("/search-total")
    public ResponseEntity<BaiVietTotalSearchDTO> searchAndGetAll(@RequestBody BaiVietTotalSearchDTO dto) {
        log.info(" start rest to searchAndGetAll with :{}", dto);
        baiVietService.searchBaiVietGetTotal(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaiVietDTO> findByID(@PathVariable("id") Integer id) {
        log.info("start rest to findByID WITH ID:{}", id);
        BaiVietDTO dto = baiVietService.findById(id);
        return new ResponseEntity<BaiVietDTO>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody BaiVietDTO dto) throws ResultException {
        log.info(" start rest to add bai viet with :{}", dto);
        baiVietService.add(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
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

    @GetMapping("/all")
    public ResponseEntity<List<BaiVietDTO>> getAllBVandCm(){
        log.info("start res to get getAllBVandCm");
        return new ResponseEntity<>(baiVietService.getBaiVietWithComment(),HttpStatus.OK);
    }

    @GetMapping("/detail-baiviet/{idBV}")
    public ResponseEntity<BaiVietDTO> getDetailBVCMREM(@PathVariable("idBV") Integer idBV){
        log.info("start res to get getDetailBVCMREM with idBV: {}",idBV);
        return new ResponseEntity<>(baiVietService.getDetailBVCMREM(idBV),HttpStatus.OK);
    }
    @GetMapping("/by-cd/{idChuDe}")
    public ResponseEntity<List<BaiVietDTO>> getAllBVandCm(@PathVariable("idChuDe") Integer idChuDe){
        log.info("start res to get getAllBVandCm");
        return new ResponseEntity<>(baiVietService.getAllByChuDe(idChuDe),HttpStatus.OK);
    }

    @GetMapping("/all-total")
    public ResponseEntity<List<BaiVietDTO>> getBVandTotal(){
        log.info("start res to get getAllBVandCm");
        return new ResponseEntity<>(baiVietService.getBVandTotalComment(),HttpStatus.OK);
    }

}
