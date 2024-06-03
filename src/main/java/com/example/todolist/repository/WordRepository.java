package com.example.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todolist.model.Word;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
}
