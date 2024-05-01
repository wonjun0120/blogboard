package com.wonjun.blogboard.repository;

import com.wonjun.blogboard.entity.Article;
import com.wonjun.blogboard.entity.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Test
    void findByArticleId() {
        /* Case 1: find all 3 article's comments */
        {
            Long articleId = 3L;
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            Article article = new Article(3L, "다다다다", "3333");
            Comment a = new Comment(1L, article, "나다", "다?");
            Comment b = new Comment(2L, article, "나다다", "다다?");
            Comment c = new Comment(3L, article, "나다다다", "다다다다?");
            List<Comment> expected = Arrays.asList(a, b, c);

            assertEquals(expected.toString(), comments.toString());
        }
        /* Case 2: find all 1 article's comments */
        {
            Long articleId = 1L;
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            Article article = new Article(1L, "가가가가", "1111");
            List<Comment> expected = Arrays.asList();

            assertEquals(expected.toString(), comments.toString());
        }
    }

    @Test
    void findByNickname() {
        /* Case 1: find all comments by nickname */
        {
            String nickname = "나다";
            List<Comment> comments = commentRepository.findByNickname(nickname);

            Comment a = new Comment(1L, new Article(3L, "다다다다", "3333"),
                    "나다", "다?");
            List<Comment> expected = Arrays.asList(a);

            assertEquals(expected.toString(), comments.toString());
        }
    }
}