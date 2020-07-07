package com.da.controller;

import com.da.dto.CommentDTO;
import com.da.dto.CommentSearchDTO;
import com.da.exception.ResultException;
import org.springframework.web.bind.annotation.*;
import com.da.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/comment")
@Slf4j
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        super();
        this.commentService = commentService;
    }

    @PostMapping("/search")
    public ResponseEntity<CommentSearchDTO> searchAndGetAll(@RequestBody CommentSearchDTO dto) {
        log.info(" start rest to searchAndGetAll with :{}", dto);
        commentService.searchComment(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> findByID(@PathVariable("id") Integer id) {
        log.info("start rest to findByID WITH ID:{}", id);
        CommentDTO dto = commentService.findById(id);
        return new ResponseEntity<CommentDTO>(dto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody CommentDTO dto) throws ResultException {
        log.info(" start rest to add Comment with :{}", dto);
        commentService.add(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> edit(@RequestBody CommentDTO dto) throws ResultException {
        log.info(" start rest to edit Comment with :{}", dto);
        commentService.update(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) throws ResultException {
        log.info(" start service to delete with :{}", id);
        commentService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/is-comment/{idBV}")
    public ResponseEntity<Boolean> idComment(@PathVariable("idBV") Integer idBV, @ModelAttribute CommentDTO commentDTO) {
        log.info("start res to get idComment with id:{} and dto :{}", idBV, commentDTO);
        return new ResponseEntity<>(commentService.isCommentBV(idBV, commentDTO), HttpStatus.OK);
    }

    @GetMapping("/is-like-cm")
    public ResponseEntity<Boolean> likeComment(@RequestBody CommentDTO commentDTO) {
        return new ResponseEntity<>(commentService.isLikeCM(commentDTO),HttpStatus.OK);
    }
}
