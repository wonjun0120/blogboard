package com.wonjun.blogboard.repository;

import com.wonjun.blogboard.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.ArrayList;

@RepositoryRestResource
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
