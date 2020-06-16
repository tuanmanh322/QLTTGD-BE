package com.da.controller;

import com.da.dto.DiemActionDTO;
import com.da.dto.DiemDTO;
import com.da.dto.DiemSearchDTO;
import com.da.exception.ResultException;
import com.da.service.DiemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/diem")
@Slf4j
public class DiemController {
    private final DiemService diemService;

    public DiemController(DiemService diemService) {
        this.diemService = diemService;
    }

    public ResponseEntity<DiemDTO> searchAndGetAll(@RequestBody DiemDTO dto) {
        log.info(" start rest to searchAndGetAll with :{}", dto);
        diemService.searchDiem(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiemDTO> findByID(@PathVariable("id") Integer id) {
        log.info("start rest to findByID WITH ID:{}", id);
        DiemDTO dto = diemService.findById(id);
        return new ResponseEntity<DiemDTO>(dto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody DiemActionDTO dto) throws ResultException {
        log.info(" start rest to add lop hoc with :{}", dto);
        diemService.add(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> edit(@RequestBody DiemActionDTO dto) throws ResultException {
        log.info(" start rest to edit lop hoc with :{}", dto);
        diemService.update(dto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id")Integer id)throws ResultException{
        log.info(" start rest to delete with :{}",id);
        diemService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search-profile")
    public ResponseEntity<DiemSearchDTO> searchDTOResponseEntity(@RequestBody DiemSearchDTO dto){
        log.info(" start rest to searchDTOResponseEntity with :{}",dto);
        diemService.searchDiemByProfile(dto);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
