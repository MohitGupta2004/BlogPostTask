package com.ancilar_tasks.backendtask.Repository;

import com.ancilar_tasks.backendtask.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {
    List<Comments> findByPostId(Long postId);

    void deleteByPostId(Long postId);
}
