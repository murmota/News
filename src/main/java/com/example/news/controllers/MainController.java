package com.example.news.controllers;

import com.example.news.models.Category;
import com.example.news.models.News;
import com.example.news.services.CategoryService;
import com.example.news.services.NewsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/news")
@CrossOrigin(origins = "http://localhost:8081")
public class MainController {

    private final NewsService newsService;
    private final CategoryService categoryService;

    public MainController(NewsService newsService, CategoryService categoryService1) {
        this.newsService = newsService;
        this.categoryService = categoryService1;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
    @GetMapping("/categories/{categoryId}/news")
    public ResponseEntity<Page<News>> getNewsByCategory(@PathVariable Long categoryId, Pageable pageable) {
        Page<News> newsPage = newsService.findNewsByCategoryIdWithPaging(categoryId, pageable);
        return ResponseEntity.ok(newsPage);
    }

//    @GetMapping("/news")
//    public ResponseEntity<Page<News>> getAllNews(Pageable pageable) {
//        Page<News> newsPage = newsService.findAllNewsWithPaging(pageable);
//        return ResponseEntity.ok(newsPage);
//    }

    @GetMapping("/details/{id}")
    public ResponseEntity<News> getNewsDetailsById(@PathVariable Long id) {
        News news = newsService.findNewsById(id);
        if (news != null) {
            return ResponseEntity.ok(news);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
