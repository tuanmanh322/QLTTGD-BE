package com.da.controller;

import com.da.dto.CardDTO;
import com.da.dto.CardSearchDTO;
import com.da.exception.ResultException;
import com.da.service.CardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/card")
@Slf4j
public class CardController {
    private final CardService cardService;
    public CardController(CardService cardService){
        super();
        this.cardService=cardService;
    }
    @PostMapping("/search")
    public ResponseEntity<CardSearchDTO> searchAndGetAll(@RequestBody CardSearchDTO dto) {
        log.info(" start rest to searchAndGetAll with :{}", dto);
        cardService.searchCard(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CardDTO> findByID(@PathVariable("id") Integer id) {
        log.info("start rest to findByID WITH ID:{}", id);
        CardDTO dto = cardService.findById(id);
        return new ResponseEntity<CardDTO>(dto,HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> edit(@RequestBody CardDTO dto)throws ResultException {
        log.info(" start rest to edit Card with :{}",dto);
        cardService.update(dto);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody CardDTO dto)throws ResultException{
        log.info(" start rest to add Card with :{}",dto);
        cardService.add(dto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id")Integer id)throws ResultException {
        log.info("start rest to delete Card by id :{} ", id);
        cardService.delete(id);
        return ResponseEntity.ok().build();
    }
}
