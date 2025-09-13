package com.ancilar_tasks.backendtask.Controller;

import com.ancilar_tasks.backendtask.Service.BlogPostService;
import com.ancilar_tasks.backendtask.model.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class BlogPostController {

    private BlogPostService blogPostService;


    @Autowired
    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping("/posts")
    public List<BlogPost> getAllPosts() {
        return blogPostService.getAllPosts();
    }

    @PostMapping("/posts")
    public BlogPost createPost(@RequestBody BlogPost blogPost) {
        return blogPostService.createPost(blogPost);
    }

    @GetMapping("/posts/{id}")
    public BlogPost getPostById(@PathVariable Long id) {
        return blogPostService.getPostById(id);
    }

    @PutMapping("/posts/{id}")
    public BlogPost updatePost(@PathVariable Long id, @RequestBody BlogPost blogPost) {
        return blogPostService.updatePost(id, blogPost);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id) {
        blogPostService.deletePost(id);
    }
}
