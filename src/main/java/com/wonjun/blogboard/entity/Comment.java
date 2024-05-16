package com.wonjun.blogboard.entity;

import com.wonjun.blogboard.dto.CommentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name = "article_id")
    private Article article;

    @Column private String nickname;
    @Column private String body;

    @CreatedDate @Column(nullable = false) private LocalDateTime createdAt; // 생성일시
    @LastModifiedDate @Column(nullable = false) private LocalDateTime modifiedAt; // 수정일시

    private Comment(Article article, String nickname, String body) {
        this.article = article;
        this.nickname = nickname;
        this.body = body;
    }

    public static Comment of(Article article, String nickname, String body) {
        return new Comment(article, nickname, body);
    }

    public static Comment createComment(CommentDto dto, Article article) {
        if(!Objects.equals(dto.getArticleId(), article.getId()))
            throw new IllegalArgumentException("댓글 생성 실패, 게시글 ID가 잘못되었습니다.");

        return new Comment(
                article,
                dto.getNickname(),
                dto.getBody()
        );

    }

//    public void patch(CommentDto dto) {
//        if(this.id != dto.getId())
//            throw new IllegalArgumentException("댓글 수정 실패, 잘못된 ID가 입력되었습니다.");
//
//        if(dto.getNickname() != null)
//            this.nickname = dto.getNickname();
//        if(dto.getBody() != null)
//            this.body = dto.getBody();
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
