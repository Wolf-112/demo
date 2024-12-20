package com.example.demo.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import com.example.demo.model.domain.Article;
import com.example.demo.model.domain.Board;
import com.example.demo.model.repository.BlogRepository;
import com.example.demo.model.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogService {
    @Autowired
    //private final BlogRepository blogRepository;
    private final BoardRepository blogRepository;

//    public List<Article> findAll() {
//        return blogRepository.findAll();
//    }
    public List<Board> findAll() {
        return blogRepository.findAll();
    }

//    public Article save(AddArticleRequest request) {
//        return blogRepository.save(request.toEntity());
//    }

//    public Optional<Article> findByID(Long id) {
//        throw new UnsupportedOperationException("Unimplemented method 'findByID'");
//    }

//    public Optional<Article> findById(Long id) {
//        return blogRepository.findById(id);
//    }
public Optional<Board> findById(Long id) {
    return blogRepository.findById(id);
}

    // public void update(Long id, AddArticleRequest request) {
    //     Optional<Article> optionalArticle = blogRepository.findById(id);
    //     optionalArticle.ifPresent(article -> { // 값이 있으면 
    //         article.update(request.getTitle(), request.getContent());
    //         blogRepository.save(article);
    //     });
    // }

    public void delete(Long id) {
        blogRepository.deleteById(id);
    }
}

