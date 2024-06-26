package com.springbootstudy.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootstudy.app.domain.Memo;
import com.springbootstudy.app.mapper.MemoMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemoService {

	@Autowired
	private MemoMapper memoMapper;
	
	public void addMemo(Memo memo) {
		log.info("MemoService : addMemo(Memo memo)");
		memoMapper.addMemo(memo);
	}
	
	public void updateMemo(Memo memo) {
		log.info("MemoService : updateMemo(Memo memo)");
		memoMapper.updateMemo(memo);
	}
	
	public void deleteMemo(int no) {
		log.info("MemoService : deleteMemo(int no)");
		memoMapper.deleteMemo(no);
	}
	
	public List<Memo>memoList() {
		log.info("MemoService : MemoList()");
		return memoMapper.memoList();
	}
	
	public Memo getMemo(int no) {
		log.info("MemoService : getMemo(int no)");
		return memoMapper.findByNo(no);
	}
	
}
