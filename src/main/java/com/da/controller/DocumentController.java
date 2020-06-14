package com.da.controller;

import com.da.dto.DocumentDTO;
import com.da.dto.DocumentSearchDTO;
import com.da.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/document")
@RestController
public class DocumentController {
    private final Logger log = LoggerFactory.getLogger(DocumentController.class);

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/search")
    public ResponseEntity<DocumentSearchDTO> getAll(@RequestBody DocumentSearchDTO documentSearchDTO) {
        log.info(" start rest to ResponseEntity with :{}", documentSearchDTO);
        documentService.searchGetDocument(documentSearchDTO);
        return new ResponseEntity<>(documentSearchDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idDc}")
    public ResponseEntity<Void> delete(@PathVariable("idDc") Integer idDc) {
        log.info(" start rest to ResponseEntity with id :{}", idDc);
        documentService.delete(idDc);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Void> add(@ModelAttribute DocumentDTO documentDTO) {
        log.info(" start rest to ResponseEntity with :{}", documentDTO);
        documentService.Add(documentDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/edit/{idCD}")
    public ResponseEntity<Void> edit(@ModelAttribute DocumentDTO documentDTO,@PathVariable("idCD")Integer idCd) {
        log.info(" start rest to ResponseEntity with :{}", documentDTO);
        documentService.edit(documentDTO,idCd);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
