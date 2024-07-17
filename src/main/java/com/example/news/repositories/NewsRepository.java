package com.example.news.repositories;

import com.example.news.models.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    Page<News> findByCategoryId(Long categoryId, Pageable pageable);
//@Query("SELECT n FROM News n WHERE n.category.id = :categoryId ORDER BY n.date DESC")
//Page<News> findNewsByCategoryIdWithPaging(@Param("categoryId") Long categoryId, PageRequest pageable);
}
