package com.project.multiligual.repository;

import com.project.multiligual.entity.Language;
import com.project.multiligual.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
    // Додаткові методи, якщо необхідно
}
