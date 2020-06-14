package com.da.controller;

import com.da.model.Lop;
import com.da.repository.LopRepository;
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

import java.util.List;

@RestController
@RequestMapping("/api/lop-hoc")
@Slf4j
public class LopController {
	private final LopHocService hocService;

	 private final LopRepository lopRepository;

	public LopController(LopHocService hocService, LopRepository lopRepository) {
		this.hocService = hocService;
		this.lopRepository = lopRepository;
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

	@GetMapping("/find-by-tenlop/{tenlop}")
	public ResponseEntity<Lop> findByTenLop(@PathVariable("tenlop") String tenLop){
		log.info("start rest to find by ten lop hoc by tenLop :{} ",tenLop);
		Lop lop  = lopRepository.findByTenlop(tenLop);
		return new ResponseEntity<>(lop,HttpStatus.OK);
	}

	@PostMapping("/get-lop-hoc-by-id-the")
	public ResponseEntity<LopHocSearchDTO> getAllByIdThe(@RequestBody LopHocSearchDTO dto) {
		log.info(" start rest to searchAndGetAll with :{}", dto);
		hocService.getListLopHocByIdThe(dto);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@PostMapping("/get-hoc-ba-by-id-the")
	public ResponseEntity<LopHocSearchDTO> getHocBaByIdThe(@RequestBody LopHocSearchDTO dto) {
		log.info(" start rest to searchAndGetAll with :{}", dto);
		hocService.getListHocBaByIdThe(dto);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Lop>> getAll() {
		log.info(" start rest to getAll with");
		return new ResponseEntity<>(lopRepository.findAll(),HttpStatus.OK);
	}
}
