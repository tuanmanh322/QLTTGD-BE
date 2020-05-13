package com.da.controller;
import com.da.dto.HocSinhDTO;
import com.da.exception.ResultException;
import com.da.service.HocSinhService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ hoc-sinh")
@Slf4j
public class HocSinhController {
    private final HocSinhService hocService;

    public HocSinhController(HocSinhService hocService) {
        this.hocService = hocService;
    }
    @PostMapping("/search")
    public ResponseEntity<HocSinhDTO> searchAndGetAll(@RequestBody HocSinhDTO dto) {
        log.info(" start rest to searchAndGetAll with :{}", dto);
        hocService.searchHocSinh(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HocSinhDTO> findByID(@PathVariable("id") Integer id) {
        log.info("start rest to findByID WITH ID:{}", id);
        HocSinhDTO dto = hocService.findById(id);
        return new ResponseEntity<HocSinhDTO>(dto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody HocSinhDTO dto) throws ResultException {
        log.info(" start rest to add lop hoc with :{}", dto);
        hocService.add(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> edit(@RequestBody HocSinhDTO dto) throws ResultException {
        log.info(" start rest to edit lop hoc with :{}", dto);
        hocService.update(dto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id")Integer id)throws ResultException{
        log.info(" start service to delete with :{}",id);
        hocService.delete(id);
        return ResponseEntity.ok().build();
    }

}
