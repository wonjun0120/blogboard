package com.wonjun.blogboard.controller;

import com.wonjun.blogboard.dto.ArticleForm;
import com.wonjun.blogboard.entity.Article;
import com.wonjun.blogboard.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @Autowired // 스프링부트가 미리 생성해 놓은 리파지터리 객체 주입, DI
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String craeteArticle(ArticleForm form){
        System.out.println(form.toString());
        // DTO 엔티티로 변환
        Article article = form.toEntity();
        System.out.println(article.toString());
        // 리파지터리로 엔티티 DB 저장
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());
        return "";
    }
}
