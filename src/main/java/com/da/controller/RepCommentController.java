package com.da.controller;

import com.da.dto.RepCommentDTO;
import com.da.dto.RepCommentSearchDTO;
import com.da.exception.ResultException;
import com.da.service.RepCommentService;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/rep-comment")
@Slf4j
public class RepCommentController {
    private RepCommentService repCommentService;

    public RepCommentController(RepCommentService repCommentService) {
        super();
        this.repCommentService = repCommentService;
    }

    @PostMapping("/search")
    public ResponseEntity<RepCommentSearchDTO> searchAndGetAll(@RequestBody RepCommentSearchDTO dto) {
        log.info(" start rest to searchAndGetAll with :{}", dto);
        repCommentService.searchRepComment(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepCommentDTO> findByID(@PathVariable("id") Integer id) {
        log.info("start rest to findByID WITH ID:{}", id);
        RepCommentDTO dto = repCommentService.findById(id);
        return new ResponseEntity<RepCommentDTO>(dto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody RepCommentDTO dto) throws ResultException {
        log.info(" start rest to add Comment with :{}", dto);
        repCommentService.add(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> edit(@RequestBody RepCommentDTO dto) throws ResultException {
        log.info(" start rest to edit Comment with :{}", dto);
        repCommentService.update(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) throws ResultException {
        log.info(" start rest to delete with :{}", id);
        repCommentService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/rep-comment/{idCM}/{idBV}")
    public ResponseEntity<Boolean> repComment(@PathVariable("idCM") Integer idCM,@PathVariable("idBV") Integer idBV, @ModelAttribute RepCommentDTO repCommentDTO) {
        log.info(" start rest to repComment with idCM:{} and dto : {}", idCM, repCommentDTO);
        return new ResponseEntity<>(repCommentService.repcomment(idCM,idBV, repCommentDTO), HttpStatus.OK);
    }
}
