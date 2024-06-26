package com.springbootstudy.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.springbootstudy.app.domain.Memo;

@Mapper
public interface MemoMapper {

	void addMemo(Memo memo);
	
	void updateMemo(Memo memo);
	
	void deleteMemo(int no);
	
	@Select("SELECT * FROM memo")
	List<Memo> memoList();
	
	
	List<Memo> findAll();
	
	Memo findByNo(int no);
}
