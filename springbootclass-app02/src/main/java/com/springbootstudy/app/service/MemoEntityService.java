package com.springbootstudy.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springbootstudy.app.dto.MemoDTO;
import com.springbootstudy.app.entity.MemoEntity;
import com.springbootstudy.app.repository.MemoRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemoEntityService {

	@Autowired
	private MemoRepository memoRepository;
	
	public MemoDTO addMemo(MemoDTO memo) {
		log.info("entityService : addMemo(MemoDTO memo)");	
		MemoEntity entity = memoRepository.save(MemoDTO.toEntity(memo));
		
		return new MemoDTO(entity);
	}
	
	@Transactional
	public MemoDTO updateMemo(MemoDTO memo) {
		MemoEntity entity = memoRepository.findById(memo.getNo()).get();
		entity.updateMemo(memo);
		return new MemoDTO(entity);
	}
	
	public void deleteMemo(int no) {
		memoRepository.deleteById(no);
	}
	
	public MemoDTO getMemo(int no) {
		log.info("entityService : getMemo(int no)");	
		
		return new MemoDTO(memoRepository.findById(no).get());
	}
	
	
	public List<MemoDTO> memoList() {
		log.info("entityService : memoList()");
		
		return memoRepository.findAll(Sort.by(Sort.Direction.DESC, "no"))
				.stream()
				.map(MemoDTO::new)
				.toList();
	}
	
}
