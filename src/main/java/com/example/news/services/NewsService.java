package com.example.news.services;

import com.example.news.models.News;
import com.example.news.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Transactional(readOnly = true)
    public Page<News> findNewsByCategoryIdWithPaging(Long categoryId, Pageable pageable) {
        return newsRepository.findByCategoryId(categoryId, pageable);
    }

    @Transactional(readOnly = true)
    public Page<News> findAllNewsWithPaging(Pageable pageable) {
        return newsRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public News findNewsById(Long id) {
        return newsRepository.findById(id).orElse(null);
    }
}
