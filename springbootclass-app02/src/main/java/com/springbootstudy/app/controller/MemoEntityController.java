package com.springbootstudy.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
