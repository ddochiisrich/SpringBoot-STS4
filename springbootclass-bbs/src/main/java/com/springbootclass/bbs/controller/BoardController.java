package com.springbootclass.bbs.controller;

import java.io.PrintWriter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springbootclass.bbs.domain.BoardDTO;
import com.springbootclass.bbs.service.BoardService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@PostMapping("/delete")
	public String deleteBoard(RedirectAttributes reAttrs, HttpServletResponse response, PrintWriter out, @RequestParam("no") int no, @RequestParam("pass")String pass, @RequestParam(value="pageNum", defaultValue="1")int pageNum, @RequestParam(value="type", defaultValue="null") String type, @RequestParam(value="keyword", defaultValue="null") String keyword) {
		
		BoardDTO dto = boardService.getBoard(no, false);
		
		if(! dto.getPass().equals(pass)) {
			response.setContentType("text/html; charset=utf-8");
			out.println("<script>");
			out.println(" alert('비밀번호가 맞지 않습니다.');");
			out.println(" history.back();");
			out.println("</script>");
			return null;
			}
		
		boardService.deleteBoard(no);
		
		boolean searchOption = (type.equals("null") || keyword.equals("null")) ? false : true;
		
		reAttrs.addAttribute("pageNum", pageNum);
		if(searchOption) {
			reAttrs.addAttribute("type", type);
			reAttrs.addAttribute("keyword", keyword);
		}
		return "redirect:boardList";
	}
	
	@PostMapping("/update")
	public String updateBoard(BoardDTO dto, HttpServletResponse response, PrintWriter out, RedirectAttributes reAttrs, @RequestParam(value="pageNum", defaultValue="1")int pageNum, @RequestParam(value="type", defaultValue="null") String type, @RequestParam(value="keyword", defaultValue="null") String keyword) {
		BoardDTO board = boardService.getBoard(dto.getNo(), false);
		
		if(! board.getPass().equals(dto.getPass())) {
			response.setContentType("text/html; charset=utf-8");
			out.println("<script>");
			out.println(" alert('비밀번호가 맞지 않습니다.');");
			out.println(" history.back();");
			out.println("</script>");
			return null;
			}
		boardService.updateBoard(dto);
		
		boolean searchOption = (type.equals("null") || keyword.equals("null")) ? false : true;
		
		reAttrs.addAttribute("pageNum", pageNum);
		if(searchOption) {
			reAttrs.addAttribute("type", type);
			reAttrs.addAttribute("keyword", keyword);
		}
		return "redirect:boardList";
	}
	
	@PostMapping("/updateForm")
	public String updateBoard(Model model, HttpServletResponse response, PrintWriter out,@RequestParam("no") int no, @RequestParam("pass")String pass, @RequestParam(value="pageNum", defaultValue="1")int pageNum, @RequestParam(value="type", defaultValue="null") String type, @RequestParam(value="keyword", defaultValue="null") String keyword) {
		BoardDTO dto = boardService.getBoard(no, false);
		
		if(! dto.getPass().equals(pass)) {
			response.setContentType("text/html; charset=utf-8");
			out.println("<script>");
			out.println(" alert('비밀번호가 맞지 않습니다.');");
			out.println(" history.back();");
			out.println("</script>");
			
			return null;
		}
		
		boolean searchOption = (type.equals("null") || keyword.equals("null")) ? false : true;
		
		model.addAttribute("board", dto);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("searchOption", searchOption);
		
		if(searchOption) {
			model.addAttribute("type", type);
			model.addAttribute("keyword", keyword);
		}
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
	public String getBoard(Model model, @RequestParam("no") int no, @RequestParam(value="pageNum", defaultValue="1")int pageNum, @RequestParam(value="type", defaultValue="null") String type, @RequestParam(value="keyword", defaultValue="null") String keyword){
		BoardDTO dto = boardService.getBoard(no, true);
		boolean searchOption = (type.equals("null") || keyword.equals("null")) ? false : true;
		
		model.addAttribute("board", dto);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("searchOption", searchOption);

		if(searchOption) {
		model.addAttribute("type", type);
		model.addAttribute("keyword", keyword);
		}
		return "views/boardDetail";
		}
	
	@GetMapping({"/", "/boardList"})
	public String boardList(Model model, @RequestParam(value="pageNum", defaultValue="0")int pageNum, @RequestParam(value="type", defaultValue="null")String type, @RequestParam(value="keyword", defaultValue="null")String keyword) {
		pageNum = pageNum == 0 ? 0 : pageNum-1;
		Map<String, Object> modelMap = boardService.boardList(pageNum, type, keyword);
		
		model.addAttribute(modelMap);
		
		
		return "views/boardList";
	}
	
}
