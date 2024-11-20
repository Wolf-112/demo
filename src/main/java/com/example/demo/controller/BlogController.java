package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.model.domain.Article;
import com.example.demo.model.domain.Board;
import com.example.demo.model.repository.BoardRepository;
import com.example.demo.model.service.AddArticleRequest;
import com.example.demo.model.service.BlogService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class BlogController { 
    
    @Autowired
    com.example.demo.model.service.BlogService blogService;
    @GetMapping("/article_list")
        public String article_list(Model model) {
            List<Article> list = blogService.findAll();
            model.addAttribute("articles", list);
        return "article_list";
    }

    @GetMapping("/favicon.ico")
    public void favicon() {
        //아무 작업도 하지 않음
    }

    @GetMapping("/article_edit/{id}")
    public String article_edit(Model model, @PathVariable Long id) {
        Optional<Article> list = blogService.findByID(id);
        
        if (list.isPresent()) {
            model.addAttribute("article", list.get());
        } else {
            return "/error_page/article_error";
        }
        return "article_edit";
    }

    @PutMapping("/api/article_edit/{id}")
    public String updateArticle(@PathVariable Long id, @ModelAttribute AddArticleRequest request) {
        blogService.update(id, request);
        return "redirect:/article_list";
    }

    public class BlogRestController {
        private BlogService blogService;
        public BlogRestController(BlogService blogService) {
            this.blogService = blogService;
        }
    @PostMapping("/api/articles")
    public String addArticle(@ModelAttribute AddArticleRequest request) {
        blogService.save(request);
        return "redirect:/article_list";
    }
    }

    @GetMapping("/board_list")
    public String board_list(Model model) {
        List<Board> list = blogService.findAll();
        model.addAttribute("articles", list);
        return "board_list";
    }

    @DeleteMapping("/api/article_delete/{id}")
    public String deleteArticle(@PathVariable Long id) {
        blogService.delete(id);
        return "redirect:/article_list";
    }

    @GetMapping("/board_view/{id}") //개시판 링크 지정
    public String board_view(Model model, @PathVariable Long id) {
        Optional<Board> list = blogService.findById(id);

        if (list.isPresent()) {
            model.addAttribute("boards", list.get());
        } else {
            //처리 로직 추가 (예: 오류 페이지로 리다이렉트, 예외 처리 등)
            return "/error_page/article_error";
        }
        return "board_view";
    }

    @GetMapping("/board_write")
    public String board_write() {
        return"board_write";
    }
    
}

// 전달 변수 이름 수정 질문할 것. 