package com.project.multiligual.repository;

import com.project.multiligual.entity.CommentForPost;
import com.project.multiligual.entity.Posts;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<CommentForPost, Long> {
    Iterable<CommentForPost> findByPosts(Posts post);

    Iterable<CommentForPost> findAllByPostsPostid(long postid);
}
