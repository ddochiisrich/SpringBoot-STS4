package com.springbootclass.bbs.controller;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbootclass.bbs.domain.BoardDTO;
import com.springbootclass.bbs.service.BoardService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@PostMapping("/update")
	public String updateBoard(BoardDTO dto, HttpServletResponse response, PrintWriter out) {
		BoardDTO board = boardService.getBoard(dto.getNo());
		if(! board.getPass().equals(dto.getPass())) {
			response.setContentType("text/html; charset=utf-8");
			out.println("<script>");
			out.println(" alert('비밀번호가 맞지 않습니다.');");
			out.println(" history.back();");
			out.println("</script>");
			return null;
			}
		boardService.updateBoard(dto);
		return "redirect:boardList";
	}
	
	@PostMapping("/updateForm")
	public String updateBoard(Model model, HttpServletResponse response, PrintWriter out,@RequestParam("no") int no, @RequestParam("pass")String pass) {
		BoardDTO dto = boardService.getBoard(no);
		
		if(! dto.getPass().equals(pass)) {
			response.setContentType("text/html; charset=utf-8");
			out.println("<script>");
			out.println(" alert('비밀번호가 맞지 않습니다.');");
			out.println(" history.back();");
			out.println("</script>");
			
			return null;
		}
		model.addAttribute("board", dto);
		return "views/updateForm";
	}
	
	@PostMapping("addBoard")
	public String addBoard(BoardDTO dto) {
		boardService.addBoard(dto);
		return "redirect:boardList";
	}
	
	@GetMapping("/addBoard")
	public String addBoard() {
		return "views/writeForm";
	}
	
	@GetMapping("/boardDetail")
	public String getBoard(Model model, @RequestParam("no") int no){
		model.addAttribute("board" ,boardService.getBoard(no));
		return "views/boardDetail";
	}
	
	@GetMapping({"/", "/boardList"})
	public String boardList(Model model) {
		model.addAttribute("bList", boardService.boardList());
		
		return "views/boardList";
	}
	
}
