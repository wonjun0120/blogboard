package com.wonjun.blogboard.repository;

import com.wonjun.blogboard.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
