package com.springbootstudy.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springbootstudy.app.service.MemoEntityService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemoViewController {

	private final MemoEntityService entityService;
	
	@GetMapping("/memoListJsp")
	public String memoList(Model model) {
		model.addAttribute("mList", entityService.memoList());
		return "main";
	}
	
}
