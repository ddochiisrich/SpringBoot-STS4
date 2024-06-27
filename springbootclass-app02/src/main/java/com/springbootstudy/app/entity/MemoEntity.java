package com.springbootstudy.app.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.springbootstudy.app.dto.MemoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="memo_entity")
@EntityListeners(AuditingEntityListener.class)
public class MemoEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int no;
	
	@Column(name="title", length=30, nullable=false)
	private String title;
	
	@Column(length=20, nullable=false)
	private String writer;
	
	@Column(columnDefinition="TEXT", nullable=false)
	private String content;
	
	@CreatedDate
	@LastModifiedDate
	private Date regDate;
	
	public void updateMemo(MemoDTO dto) {
		this.title = dto.getTitle();
		this.writer = dto.getWriter();
		this.content = dto.getContent();
	}
	
}
