package com.wonjun.blogboard.service;

import com.wonjun.blogboard.dto.CommentDto;
import com.wonjun.blogboard.entity.Article;
import com.wonjun.blogboard.entity.Comment;
import com.wonjun.blogboard.repository.ArticleRepository;
import com.wonjun.blogboard.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentDto> comments(Long articleId) {
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentDto create(Long articleId, CommentDto dto) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패하였습니다." +
                        "대상 게시글이 없습니다."));

        Comment comment = Comment.createComment(dto, article);
        Comment created = commentRepository.save(comment);
        return CommentDto.createCommentDto(created);
    }
}
