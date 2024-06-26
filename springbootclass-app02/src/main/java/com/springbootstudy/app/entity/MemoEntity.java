package com.springbootstudy.app.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	
	private Date regDate;
	
}
