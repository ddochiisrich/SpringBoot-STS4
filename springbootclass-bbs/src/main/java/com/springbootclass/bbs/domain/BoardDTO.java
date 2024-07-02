package com.springbootclass.bbs.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

	private int no;
	private String title;
	private String writer;
	private String content;
	private Timestamp regDate;
	private int readCount;
	private String pass;
	private String file1;
	
	
	public BoardDTO(Board board) {
		this.no = board.getNo();
		this.title = board.getTitle();
		this.writer = board.getWriter();
		this.content = board.getContent();
		this.regDate = board.getRegDate();
		this.readCount = board.getReadCount();
		this.pass = board.getPass();
		this.file1 = board.getFile1();
	}
	
	public static Board toEntity(final BoardDTO dto) {
		return Board.builder()
				.no(dto.getNo())
				.title(dto.getTitle())
				.writer(dto.getWriter())
				.content(dto.getContent())
				.regDate(dto.getRegDate())
				.readCount(dto.getReadCount())
				.pass(dto.getPass())
				.file1(dto.getFile1())
				.build();
	}
}
