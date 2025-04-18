package com.example.newsapi.news;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsArticleService {
    private NewsArticleRepository newsArticleRepository;

    @Autowired
    public NewsArticleService(NewsArticleRepository newsArticleRepository) {
        this.newsArticleRepository = newsArticleRepository;
    }

    // 모든 데이터를 가져옴
    public Page<NewsArticle> getAllNewsArticles(Pageable pageable) {
        return newsArticleRepository.findAll(pageable);
    }

    public Page<NewsArticleDescDto> getNewsArticleByDescription(Pageable pageable) {
        Page<NewsArticle> newsArticles = newsArticleRepository.findAll(pageable);
        List<NewsArticleDescDto> newsDescDto = newsArticles.getContent().stream()
                .map(article -> new NewsArticleDescDto(
                        article.getYnaTtl(),
                        article.getNewsLink(),
                        article.getYnaYmd()))
                .collect(Collectors.toList());
        return new PageImpl<>(newsDescDto, pageable, newsArticles.getTotalElements());
    }
    
    // ynaTtl: 검색어, pageable: 페이지
    public Page<NewsArticleResponseDto> searchNewsArticles(String ynaTtl,Pageable pageable) {
        Page<NewsArticle> newsArticles = newsArticleRepository.findByYnaTtlContainingIgnoreCase(ynaTtl, pageable);
        if(newsArticles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"검색어에 맞는 기사가 없습니다!");
        }
        List<NewsArticleResponseDto> newsResDto = newsArticles.getContent().stream()
                .map(article -> new NewsArticleResponseDto(
                        article.getYnaTtl(),        // 제목
                        article.getNewsLink(),      // 링크
                        article.getYnaCn(),         // 내용
                        article.getYnaYmd()))       // 연도
                .collect(Collectors.toList());
        return new PageImpl<>(newsResDto, pageable, newsArticles.getTotalElements());

    }
}
