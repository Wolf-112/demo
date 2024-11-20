package com.example.demo.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import com.example.demo.model.domain.Article;
import com.example.demo.model.repository.BlogRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogService {
    @Autowired
    private final BlogRepository blogRepository;

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article save(AddArticleRequest request) {
        // TODO Auto-generated method stub
        return blogRepository.save(request.toEntity());
    }

    public Optional<Article> findByID(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByID'");
    }

    public Optional<Article> findById(Long id) {
        return blogRepository.findById(id);
    }

    public void update(Long id, AddArticleRequest request) {
        Optional<Article> optionalArticle = blogRepository.findByID(id);
        optionalArticle.ifPresent(article -> { // 값이 있으면 
            article.update(request.getTitle(), request.getContent());
            blogRepository.save(article);
        });
    }

    public void delete(Long id) {
        blogRepository.deleteByID(id);
    }
}

