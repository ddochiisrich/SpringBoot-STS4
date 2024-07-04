package com.springbootclass.bbs.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springbootclass.bbs.domain.Board;
import com.springbootclass.bbs.domain.BoardDTO;
import com.springbootclass.bbs.repository.BoardRepository;

import jakarta.transaction.Transactional;

@Service
public class BoardService {

	private static final int PAGE_SIZE = 10;
	
	@Autowired
	private BoardRepository boardRepository;
	
	public void deleteBoard(int no) {
		boardRepository.deleteById(no);
	}
	
	@Transactional
	public BoardDTO updateBoard(BoardDTO dto) {
		Board board = boardRepository.findById(dto.getNo()).get();
		
		board.updateBoard(dto);
		
		return new BoardDTO(board);
	}
	
	public BoardDTO addBoard(BoardDTO dto) {
		Board board = boardRepository.save(BoardDTO.toEntity(dto));
		return new BoardDTO(board);
	}
	
	@Transactional
	public BoardDTO getBoard(int no, boolean isCount) {
		if(isCount) {
			Board board = boardRepository.findById(no).get();
			
			board.incrementReadCount();
		}
		
		return new BoardDTO(boardRepository.findById(no).get());
	}
	
	public Map<String, Object> boardList(int pageNum, String type, String keyword){
		boolean searchOption = (type.equals("null") || keyword.equals("null")) ? false : true;
		
		PageRequest pageable = PageRequest.of(pageNum, PAGE_SIZE, Sort.by(Sort.Direction.DESC, "no"));
		Page<Board> boardPage = null;
		
		if(searchOption && type.equals("title")) {
			boardPage = boardRepository.findByTitleLike(pageable, "%" + keyword + "%");
		}else if(searchOption && type.equals("writer")) {
			boardPage = boardRepository.findByTitleLike(pageable, "%" + keyword + "%");
		}else if (searchOption && type.equals("content")) {
			boardPage = boardRepository.findByTitleLike(pageable, "%" + keyword + "%");
		}else {
			boardPage = boardRepository.findAll(pageable);
		}
		
		Page<BoardDTO> dtoPage = boardPage.map(board -> new BoardDTO(board));
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("page", dtoPage);
		modelMap.put("searchOption", searchOption);
		
		if(searchOption) {
			modelMap.put("type", type);
			modelMap.put("keyword", keyword);
		}
		
		
		return modelMap;
	}
	
}
