package com.project.multiligual.repository;

import com.project.multiligual.entity.Posts;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PostRepository extends CrudRepository<Posts, Long> {


    List<Posts> findAllByUserId(long user_id);

}
