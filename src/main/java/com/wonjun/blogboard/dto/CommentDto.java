package com.wonjun.blogboard.dto;

import com.wonjun.blogboard.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CommentDto {
//    private Long id;
    private Long articleId;
    private String body;

    public static CommentDto createCommentDto(Comment comment) {
        return new CommentDto(
                comment.getArticle().getId(),
                comment.getBody()
        );
    }
}
