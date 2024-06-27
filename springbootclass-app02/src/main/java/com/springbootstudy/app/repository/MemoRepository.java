package com.springbootstudy.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootstudy.app.entity.MemoEntity;

public interface MemoRepository extends JpaRepository<MemoEntity, Integer> {

}
