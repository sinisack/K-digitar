package com.example.newsapi.disaster;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisasterMessageRepository extends JpaRepository<DisasterMessage, Long> {
    // 모든 데이터를 찾아옴
    Page<DisasterMessage> findAll(Pageable pageable);

    // 검색어 입력시 관련 키워드만 찾는다.
    Page<DisasterMessage> findByMsgCnContaining(String keyword, Pageable pageable);
}
