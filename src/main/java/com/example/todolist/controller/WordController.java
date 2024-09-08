package com.example.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todolist.model.Word;
import com.example.todolist.service.WordService;

@Controller
public class WordController {

    @Autowired
    private WordService wordService;

    @GetMapping("/words")
    public String showIndexPage(Model model) {
        List<Word> words = wordService.getAllWords(); // Fetch all words
        model.addAttribute("words", words); // Add the words list to the model
        return "index"; // Renders the index.html page
    }

    // Handle POST request for adding a new word
    @PostMapping("/words/add")
    public String addWord(@RequestParam("word") String wordText) {
        Word word = new Word();
        word.setWord(wordText);
        wordService.saveWord(word);  // Save the word using the service
        return "redirect:/words"; // Redirect to the word list page after saving
    }
}
