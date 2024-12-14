package com.example.demo.model.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.demo.model.domain.Article;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity(){
        return Article.builder()
            .title(title)
            .content(content)
            .build();
    }
}