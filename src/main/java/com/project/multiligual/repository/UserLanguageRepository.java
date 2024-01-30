package com.project.multiligual.repository;

import com.project.multiligual.entity.Posts;
import com.project.multiligual.entity.User;
import com.project.multiligual.entity.UserLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLanguageRepository extends CrudRepository<UserLanguage, Long> {
    // Додаткові методи, якщо необхідно
}
