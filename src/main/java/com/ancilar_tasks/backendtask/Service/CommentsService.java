package com.ancilar_tasks.backendtask.Service;

import com.ancilar_tasks.backendtask.Repository.CommentsRepository;
import com.ancilar_tasks.backendtask.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {

    private CommentsRepository commentsRepository;

    @Autowired
    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public void addCommentToPost(Comments comment) {
        commentsRepository.save(comment);
    }

    public List<Comments> getCommentsForPost(Long postId) {
        return commentsRepository.findByPostId(postId);
    }

    public void deleteCommentById(Long commentId) {
        commentsRepository.deleteById(commentId);
    }

    //delete comments by postId
    public void deleteCommentsByPostId(Long postId) {
        commentsRepository.deleteByPostId(postId);
    }
}
