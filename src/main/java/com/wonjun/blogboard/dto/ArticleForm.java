package com.wonjun.blogboard.dto;

import com.wonjun.blogboard.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
//    private Long id;
    private String title;
    private String content;

    public Article toEntity() {
        return Article.of(title, content);
    }
}
