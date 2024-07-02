package com.springbootclass.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springbootclass.bbs.domain.Board;
import com.springbootclass.bbs.domain.BoardDTO;
import com.springbootclass.bbs.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	public BoardDTO addBoard(BoardDTO dto) {
		Board board = boardRepository.save(BoardDTO.toEntity(dto));
		return new BoardDTO(board);
	}
	
	public BoardDTO getBoard(int no) {
		return new BoardDTO(boardRepository.findById(no).get());
	}
	
	public List<BoardDTO> boardList(){
		return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "no"))
				.stream().
				map(BoardDTO::new)
				.toList();
	}
	
}
