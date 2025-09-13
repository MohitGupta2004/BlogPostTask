package com.ancilar_tasks.backendtask.Controller;

import com.ancilar_tasks.backendtask.Service.CommentsService;
import com.ancilar_tasks.backendtask.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//CommentsController
@RestController
public class CommentsController {

    private final CommentsService commentsService;

    @Autowired
    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    //POST /posts/:id/comments: Add a comment to a post.
    //GET /posts/:id/comments: List comments for a post.
    //DELETE /comments/:id: Delete a specific comment.

    @PostMapping("/posts/{postId}/comments")
    public void addCommentToPost(@RequestBody Comments comment) {
        commentsService.addCommentToPost(comment);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<Comments> listCommentsForPost(@PathVariable Long postId) {
        return commentsService.getCommentsForPost(postId);
    }

    @DeleteMapping("/comments/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentsService.deleteCommentById(commentId);
    }




}
