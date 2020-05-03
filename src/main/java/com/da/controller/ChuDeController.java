package com.da.controller;
import com.da.service.ChuDeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.da.dto.ChuDeSearchDTO;
import com.da.dto.ChuDeDTO;
import lombok.extern.slf4j.Slf4j;

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
}