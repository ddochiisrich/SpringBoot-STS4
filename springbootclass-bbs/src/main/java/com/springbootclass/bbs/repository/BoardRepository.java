package com.springbootclass.bbs.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springbootclass.bbs.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{
	
	Page<Board> findByTitleLike(Pageable pageable, String keyword);
	Page<Board> findByWriterLike(Pageable pageable, String keyword);
	Page<Board> findByContentLike(Pageable pageable, String keyword);
	
	@Query("SELECT b FROM Board b WHERE b.title LIKE CONCAT('%', :keyword, '%')")
	Page<Board> searchTitleLike(@Param("keyword") String keyword, Pageable pageable);
	
}
