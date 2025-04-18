# K-디지털

뉴스와 재난문자 데이터를 수집하고 제공하는 Spring Boot 기반 API 프로젝트입니다.


## 🔧 사용 기술
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Swagger (API 문서)


## 🗂️ 주요 패키지 구조
com.example.newsapi
│
├── disaster                           # 재난 문자 관련 기능
│   ├── DisasterMessage.java           // 재난 문자 엔티티
│   ├── DisasterMessageService.java    // 재난 문자 비즈니스 로직
│   ├── DisasterMessageRepository.java // 재난 문자 JPA 레포지토리
│   └── DisasterMessageContorller.java // 재난 문자 REST 컨트롤러
│
├── news                               # 뉴스 기사 관련 기능
│   ├── NewsArticle.java               // 뉴스 기사 엔티티
│   ├── NewsArticleService.java        // 뉴스 기사 비즈니스 로직
│   ├── NewsArticleRepository.java     // 뉴스 기사 JPA 레포지토리
│   ├── NewsArticleController.java     // 뉴스 기사 REST 컨트롤러
│   ├── NewsArticleDescDto.java        // 뉴스 요약 DTO
│   └── NewsArticleResponseDto.java    // 뉴스 상세 DTO
│
└── GlobalExceptionHandler.java        // 전역 예외 처리 클래스


## 테스트 정보
Swagger 문서
http://localhost:8080/swagger-ui.html
또는
http://localhost:8080/swagger-ui/index.html


## H2 콘솔 접속
주소: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:tcp://localhost/~/newsdata

username: sa

password: 없음 (비어 있음)
