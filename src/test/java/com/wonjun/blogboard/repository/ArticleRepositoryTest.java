package com.wonjun.blogboard.repository;

import com.wonjun.blogboard.config.JpaConfig;
import com.wonjun.blogboard.entity.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class ArticleRepositoryTest {
    @Autowired private ArticleRepository articleRepository;

    @DisplayName("select 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorksFine() {
        // Given

        // When
        List<Article> articles = articleRepository.findAll();

        // Then
        assertNotNull(articles);
        assertEquals(articles.size(), 100);
    }

    @DisplayName("insert 테스트")
    @Test
    void givenTestData_whenInserting_thenWorksFine() {
        // Given
        long previousCount = articleRepository.count();

        // When
        articleRepository.save(Article.of("test article", "test content"));

        // Then
        assertEquals(articleRepository.count(), previousCount + 1);
    }

    @DisplayName("update 테스트")
    @Test
    void givenTestData_whenUpdating_thenWorksFine() {
        // Given
        Article article = articleRepository.findById(1L).orElseThrow();
        article.setTitle("update test article");

        // When
        Article savedArticle = articleRepository.saveAndFlush(article);

        // Then
        assertEquals(articleRepository.findById(1L).orElseThrow().getTitle(), savedArticle.getTitle());
    }

    @DisplayName("delete 테스트")
    @Test
    void givenTestData_whenDeleting_thenWorksFine() {
        // Given
        long previousCount = articleRepository.count();
        Article article = articleRepository.findById(1L).orElseThrow();

        // When
        articleRepository.delete(article);

        // Then
        Long newCount = articleRepository.count();
        assertEquals(previousCount - 1, newCount);
    }

}