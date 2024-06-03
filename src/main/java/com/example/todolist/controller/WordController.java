package com.example.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.model.Word;
import com.example.todolist.repository.WordRepository;

@RestController
@RequestMapping("/api/words")
public class WordController {

    @Autowired
    private WordRepository wordRepository;

    @PostMapping
    public Word saveWord(@RequestBody Word word) {
        return wordRepository.save(word);
    }

    @GetMapping
    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }
}
