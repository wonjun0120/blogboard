//package com.wonjun.blogboard.controller;
//
//import com.wonjun.blogboard.dto.ArticleForm;
//import com.wonjun.blogboard.entity.Article;
//import com.wonjun.blogboard.repository.ArticleRepository;
//import com.wonjun.blogboard.service.ArticleService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Slf4j
//@RestController
//public class ArticleAPIController {
//
//    @Autowired
//    private ArticleService articleService;
//
//    @GetMapping("/api/articles")
//    public List<Article> index() {
//        return articleService.index();
//    }
//
//    @GetMapping("/api/articles/{id}")
//    public Article show(@PathVariable Long id){
//        return articleService.show(id);
//    }
//
//    @PostMapping("/api/articles")
//    public ResponseEntity<Article> create(@RequestBody ArticleForm dto){
//        Article created = articleService.create(dto);
//        return (created != null) ?
//                ResponseEntity.status(HttpStatus.OK).body(created) :
//                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//    }
//
//    @PatchMapping("/api/articles/{id}")
//    public ResponseEntity<Article> update(@PathVariable Long id,
//                                          @RequestBody ArticleForm dto) {
//        Article updated = articleService.update(id, dto);
//        return (updated != null) ?
//                ResponseEntity.status(HttpStatus.OK).body(updated) :
//                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//    }
//
//    @DeleteMapping("/api/articles/{id}")
//    public ResponseEntity<Article> delete (@PathVariable Long id){
//        Article deleted = articleService.delete(id);
//        return (deleted != null) ?
//                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
//                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//    }
//}
