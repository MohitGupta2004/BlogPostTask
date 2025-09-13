package com.ancilar_tasks.backendtask.Repository;

import com.ancilar_tasks.backendtask.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

}
