package com.giveus.config;

import com.giveus.common.auth.JwtAuthenticationFilter;
import com.giveus.common.auth.SsafyUserDetailService;
import com.giveus.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 인증(authentication) 와 인가(authorization) 처리를 위한 스프링 시큐리티 설정 정의.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final SsafyUserDetailService ssafyUserDetailService;
    //    private final UserService userService;
    private final AuthenticationConfiguration authConfig;

    // Password 인코딩 방식에 BCrypt 암호화 방식 사용
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        // DAO 기반으로 Authentication Provider를 생성
        // BCrypt Password Encoder와 UserDetailService 구현체를 설정
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.ssafyUserDetailService);
        return daoAuthenticationProvider;
    }

    @Bean
    AuthenticationManager authenticationManager() throws Exception {
        // DAO 기반의 Authentication Provider가 적용되도록 설정
        return new ProviderManager(authenticationProvider());
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/v3/**", "/swagger-ui/**", "/swagger-resources/**")
                .permitAll()
                .requestMatchers("/api/v1/users/me")
                .authenticated() //인증이 필요한 URL과 필요하지 않은 URL에 대하여 설정
                .anyRequest().permitAll())
            .httpBasic(HttpBasicConfigurer::disable)
            .csrf(CsrfConfigurer::disable)
            .sessionManagement(  // 토큰 기반 인증이므로 세션 사용 하지않음
                configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilter( //HTTP 요청에 JWT 토큰 인증 필터를 거치도록 필터를 추가
                new JwtAuthenticationFilter(authenticationManager(), this.ssafyUserDetailService))
            .cors(Customizer.withDefaults());

        return http.build();
    }
}