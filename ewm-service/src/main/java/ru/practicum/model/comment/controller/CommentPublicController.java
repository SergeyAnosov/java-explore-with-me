package ru.practicum.model.comment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.model.comment.dto.ResponseCommentDto;
import ru.practicum.model.comment.service.CommentService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping
public class CommentPublicController {

    private final CommentService commentService;

    public CommentPublicController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * Получение всех комментариев по Id события
     */
    @GetMapping("/events/{eventId}/comments")
    public List<ResponseCommentDto> getAllCommentsByEventId(@PathVariable Long eventId) {
        log.info("GET CommentPublicController получение всех комментариев события c id={}", eventId);
        return commentService.getAllCommentByEventId(eventId);
    }
}