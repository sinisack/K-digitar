package com.example.newsapi.disaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DisasterMessageService {
    private final DisasterMessageRepository disasterMessageRepository;

    @Autowired
    public DisasterMessageService(DisasterMessageRepository disasterMessageRepository) {
        this.disasterMessageRepository = disasterMessageRepository;
    }
    // 모든 데이터를 찾기 위한 메소드
    public Page<DisasterMessage> findAll(Pageable pageable) {
        return disasterMessageRepository.findAll(pageable);
    }

    // 검색시 검색어와 페이지의 값을 전달함.
    public Page<DisasterMessage> searchDisasterMessages(String keyword, Pageable pageable) {
        return disasterMessageRepository.findByMsgCnContaining(keyword, pageable);
    }

    
}
