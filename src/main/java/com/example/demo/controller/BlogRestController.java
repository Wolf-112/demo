package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.domain.Article;
import com.example.demo.model.service.AddArticleRequest;
import com.example.demo.model.service.BlogService;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@RestController // @Controller + @ResponseBody
public class BlogRestController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@ModelAttribute AddArticleRequest request) {
        Article saveArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(saveArticle);
    }

    @GetMapping("/faviction.ico")
    public void favicon() {}

    @GetMapping("/article_edit/{id}")
    public String article_edit(Model model, @PathVariable Long id) {
        Optional<Article> list = blogService.findByID(id);

        if (list.isPresent()) {
            model.addAttribute("article", list.get());
        } else {
            return "error";
        }
        return "article_edit";
    }   
    
    
}