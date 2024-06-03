package com.example.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }

    @PostMapping
    public Word createWord(@RequestBody Word word) {
        return wordRepository.save(word);
    }

        // Endpoint to check database connection
    @GetMapping("/check")
    public ResponseEntity<String> checkConnection() {
        try {
            wordRepository.findAll();
            return ResponseEntity.ok("Database connection is successful!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to connect to the database: " + e.getMessage());
        }
    }
}
