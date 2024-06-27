package com.springbootstudy.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootstudy.app.dto.MemoDTO;
import com.springbootstudy.app.service.MemoEntityService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemoEntityController {

	private final MemoEntityService entityService;
	
	@PostMapping("/jpaMemos")
	public ResponseEntity<MemoDTO> addMemo(@RequestBody MemoDTO memo) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(entityService.addMemo(memo));
	}
	
	@PutMapping("/jpaMemos")
	public ResponseEntity<MemoDTO> updateMemo(MemoDTO memo){
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(entityService.updateMemo(memo));
	}
	
	@DeleteMapping("/jpaMemos")
	public Map<String, Object> deleteMemo(@RequestParam("no") int no){
		entityService.deleteMemo(no);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", true);
		
		return resultMap;
	}
	
	
	@GetMapping("/jpaMemos")
	public ResponseEntity<List<MemoDTO>> memoList(){

		return ResponseEntity
				.ok()
				.body(entityService.memoList());
	}
	
	@GetMapping("/jpaMemos/{no}")
	public MemoDTO getMemo(@PathVariable("no") int no) {
		return entityService.getMemo(no);
	}
	
}
