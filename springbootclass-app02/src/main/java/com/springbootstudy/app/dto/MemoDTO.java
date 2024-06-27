package com.springbootstudy.app.dto;

import java.util.Date;

import com.springbootstudy.app.entity.MemoEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemoDTO {

	private int no;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	
	public MemoDTO(MemoEntity entity) {
		this.no = entity.getNo();
		this.title = entity.getTitle();
		this.writer = entity.getWriter();
		this.content = entity.getContent();
		this.regDate = entity.getRegDate();				
	}
	
	public static MemoEntity toEntity(final MemoDTO dto) {
		return MemoEntity.builder()
					.no(dto.getNo())
					.title(dto.getTitle())
					.writer(dto.getWriter())
					.content(dto.getContent())
//					.regDate(new Date())
					.build();
	}
	
}
