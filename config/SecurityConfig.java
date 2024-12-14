package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig { 

    @Bean // 명시적 의존성 주입 : Autowired와 다름
    // 5.7버전 이저 WebSecurityConfigurerAdapter 사용
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { 
        //설정 비워둠
        return http.build(); //필터 체인 통해 보안설정을 반환
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

