package com.da.controller;
import com.da.dto.BaiVietDTO;
import com.da.dto.BaiVietSearchDTO;
import com.da.dto.BaiVietTotalSearchDTO;
import com.da.dto.CommentDTO;
import com.da.exception.ResultException;
import org.springframework.http.ResponseEntity;
import com.da.service.BaiVietService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/search-total-id-cd/{idCD}")
    public ResponseEntity<BaiVietTotalSearchDTO> searchAndGetAllByIdCD(@RequestBody BaiVietTotalSearchDTO dto,@PathVariable("idCD")Integer idCD) {
        log.info(" start rest to searchAndGetAllByIdCD with :{} and idCD: {}", dto,idCD);
        baiVietService.searchBaiVietGetTotalByIdCD(dto,idCD);
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

    @PostMapping("/like/{idBV}")
    public ResponseEntity<Boolean> isLikeOrUnlike(@PathVariable("idBV")Integer idBV, @RequestBody BaiVietDTO baiVietDTO){
        log.info("start res to get isLikeOrUnlike with id:{} and dto :{}",idBV,baiVietDTO);
        return new ResponseEntity<>( baiVietService.isLikeOrUnLikeBV(idBV,baiVietDTO),HttpStatus.OK);
    }

    @PostMapping("/dislike/{idBV}")
    public ResponseEntity<Boolean> isDisLikeOrUnDislike(@PathVariable("idBV")Integer idBV, @RequestBody BaiVietDTO baiVietDTO){
        log.info("start res to get isDisLikeOrUnDislike with id:{} and dto :{}",idBV,baiVietDTO);
        return new ResponseEntity<>( baiVietService.isDislikeOrUnDisLikeBV(idBV,baiVietDTO),HttpStatus.OK);
    }



}
