package com.da.controller;

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

import com.da.dto.LopHocDTO;
import com.da.dto.LopHocSearchDTO;
import com.da.exception.ResultException;
import com.da.service.LopHocService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/lop-hoc")
@Slf4j
public class LopController {
	private final LopHocService hocService;

	public LopController(LopHocService hocService) {
		super();
		this.hocService = hocService;
	}

	@PostMapping("/search")
	public ResponseEntity<LopHocSearchDTO> searchAndGetAll(@RequestBody LopHocSearchDTO dto) {
		log.info(" start rest to searchAndGetAll with :{}", dto);
		hocService.searchLopHoc(dto);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<LopHocDTO> findByID(@PathVariable("id") Integer id) {
		log.info("start rest to findByID WITH ID:{}", id);
		LopHocDTO dto = hocService.findById(id);
		return new ResponseEntity<LopHocDTO>(dto,HttpStatus.OK);
	}
	
	@PutMapping("/edit")
	public ResponseEntity<Void> edit(@RequestBody LopHocDTO dto)throws ResultException{
		log.info(" start rest to edit lop hoc with :{}",dto);
		hocService.update(dto);
		return ResponseEntity.ok().build();
	}
	@PostMapping("/add")
	public ResponseEntity<Void> add(@RequestBody LopHocDTO dto)throws ResultException{
		log.info(" start rest to add lop hoc with :{}",dto);
		hocService.add(dto);
		return ResponseEntity.ok().build();
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id")Integer id)throws ResultException{
		log.info("start rest to delete lop hoc by id :{} ",id);
		hocService.delete(id);
		return ResponseEntity.ok().build();
	}

}
