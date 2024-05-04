package com.wonjun.blogboard.service;

import com.wonjun.blogboard.dto.CommentDto;
import com.wonjun.blogboard.entity.Comment;
import com.wonjun.blogboard.repository.ArticleRepository;
import com.wonjun.blogboard.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentDto> comments(Long articleId) {
        List<Comment> comments = commentRepository.findByArticleId(articleId);
        List<CommentDto> dtos = new ArrayList<CommentDto>();
        for(int i = 0; i < comments.size(); i++) {
            Comment c = comments.get(i);
            CommentDto dto = CommentDto.createCommentDto(c);
            dtos.add(dto);
        }

        return dtos;
    }
}
