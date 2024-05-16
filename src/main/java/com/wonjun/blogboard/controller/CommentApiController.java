//package com.wonjun.blogboard.controller;
//
//import com.wonjun.blogboard.dto.CommentDto;
//import com.wonjun.blogboard.service.CommentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class CommentApiController {
//    @Autowired
//    private CommentService commentService;
//
//    @GetMapping("/api/articles/{articleId}/comments")
//    public ResponseEntity<List<CommentDto>> comments (@PathVariable Long articleId) {
//        List<CommentDto> dtos = commentService.comments(articleId);
//
//        return ResponseEntity.status(HttpStatus.OK).body(dtos);
//    }
//
//    @PostMapping("/api/articles/{articleId}/comments")
//    public ResponseEntity<CommentDto> create (@PathVariable Long articleId,
//                                              @RequestBody CommentDto dto) {
//        CommentDto commentDto = commentService.create(articleId, dto);
//        return ResponseEntity.status(HttpStatus.OK).body(commentDto);
//    }
//
//    @PatchMapping("/api/comments/{id}")
//    public ResponseEntity<CommentDto> update(@PathVariable Long id,
//                                             @RequestBody CommentDto dto) {
//        CommentDto updateDto = commentService.update(id, dto);
//        return ResponseEntity.status(HttpStatus.OK).body(updateDto);
//    }
//
//    @DeleteMapping("/api/comments/{id}")
//    public ResponseEntity<CommentDto> delete (@PathVariable Long id) {
//        CommentDto deleteDto = commentService.delete(id);
//        return ResponseEntity.status(HttpStatus.OK).body(deleteDto);
//    }
//}
