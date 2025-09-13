package com.ancilar_tasks.backendtask.Service;

import com.ancilar_tasks.backendtask.Repository.BlogPostRepository;
import com.ancilar_tasks.backendtask.model.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {

    private BlogPostRepository postRepository;
    private CommentsService commentsService;

    @Autowired
    public BlogPostService(BlogPostRepository postRepository, CommentsService commentsService) {
        this.postRepository = postRepository;
        this.commentsService = commentsService;
    }

    public BlogPost createPost(BlogPost post) {
        return postRepository.save(post);
    }

    public BlogPost getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public List<BlogPost> getAllPosts() {
        return postRepository.findAll();
    }

    public BlogPost updatePost(Long id, BlogPost updatedPost) {
        return postRepository.findById(id).map(post -> {
            post.setTitle(updatedPost.getTitle());
            post.setContent(updatedPost.getContent());
            return postRepository.save(post);
        }).orElse(null);
    }
    public void deletePost(Long id) {
        postRepository.deleteById(id);
        commentsService.deleteCommentsByPostId(id);

    }
}
