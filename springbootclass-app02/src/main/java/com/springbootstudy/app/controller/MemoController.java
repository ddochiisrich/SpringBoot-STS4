package com.springbootstudy.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootstudy.app.domain.Memo;
import com.springbootstudy.app.service.MemoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemoController {

	private final MemoService memoService;
	
	@PostMapping("/memos")
	public Map<String, Object> addMemo(Memo memo) {
		memoService.addMemo(memo);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result",  true);
		resultMap.put("memo", memo);
		
		
		return resultMap;
	}
	
	@PutMapping("/memos")
	public Map<String, Object> updateMemo(Memo memo){
		memoService.updateMemo(memo);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", true);
		
		return resultMap;

	}
	
	@DeleteMapping("/memos")
	public Map<String, Object> deleteMemo(@RequestParam("no") int no) {
		memoService.deleteMemo(no);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", true);
		
		return resultMap;
	}
	
	@GetMapping("/memos")
	public List<Memo> memoList() {
		return memoService.memoList();
	}
	
	@GetMapping("/memos/{no}")
	public Memo getMemo(@PathVariable("no")int no) {
		return memoService.getMemo(no);
	}
	
}
