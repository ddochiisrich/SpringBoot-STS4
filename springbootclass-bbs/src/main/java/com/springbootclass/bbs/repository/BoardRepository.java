package com.springbootclass.bbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootclass.bbs.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{
	
	
	
}
