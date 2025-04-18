package com.example.newsapi.news;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//CRUD를 위한 레포지토리
@Repository
public interface NewsArticleRepository extends JpaRepository<NewsArticle, Long> {
    // 검색어 입력시 관련 키워드만 찾는다.
    Page<NewsArticle> findByYnaTtlContainingIgnoreCase(String ynaTtl, Pageable pageable);

}
