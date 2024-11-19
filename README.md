# Spring Social

    Spring Social은  2020년 7월 1일자로 공식적으로 EOL(End of Life) 되었습니다.
    대신, OAuth 2.0 및 OpenID Connect 표준을 따르는 "Spring Security"를 사용하여 
    소셜 로그인 및 통합 기능을 구현하는 것이 권장됩니다.

# Spring Security & Social

    1. 의존성
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-oauth2-client</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>

    2. application.properties 구성
        # OAuth2 클라이언트 설정
        # OAuth2 프로바이더 설정

    3. SecurityConfig 구성
        SecurityFilterChain 접근 권한 설정

    4. Controller 구성
        login
        logout

    # Social 서비스 공급자
        client-id, client-secret 설정
        https://notspoon.tistory.com/45



