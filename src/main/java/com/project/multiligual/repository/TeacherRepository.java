package com.project.multiligual.repository;

import com.project.multiligual.entity.Posts;
import com.project.multiligual.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {

}
