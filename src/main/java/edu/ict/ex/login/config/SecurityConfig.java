package edu.ict.ex.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import edu.ict.ex.login.filter.CustomLogoutFilter;
import edu.ict.ex.login.filter.JWTFilter;
import edu.ict.ex.login.filter.JWTUtil;
import edu.ict.ex.login.filter.LoginFilter;
import edu.ict.ex.login.mapper.RefreshTokenMapper;
import edu.ict.ex.login.service.CustomOAuth2UserService;
import edu.ict.ex.login.service.LogoutService;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final AuthenticationConfiguration authenticationConfiguration;
    private final JWTUtil jwtUtil;  // JWTUtil 객체 주입
    private final RefreshTokenMapper refreshTokenMapper;  // RefreshRepository 객체 주입
    private final LogoutService logoutService;  // LogoutService 객체 주입
    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public static  BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // CORS 설정 추가
        http.cors(); 
        
        // CSRF 비활성화
        http.csrf().disable();
        
        // 기본 폼 로그인 비활성화
        http.formLogin().disable();

        // HTTP Basic 인증 비활성화
        http.httpBasic().disable();

        // OAuth2 로그인 설정
        http.oauth2Login(oauth2 -> oauth2.userInfoEndpoint(userInfoEndPoint ->
            userInfoEndPoint.userService(customOAuth2UserService))
        );

        // JWT 필터 추가
        http.addFilterBefore(new JWTFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class)
            .addFilterAt(new LoginFilter(authenticationManager(authenticationConfiguration), jwtUtil, refreshTokenMapper), UsernamePasswordAuthenticationFilter.class)
            .addFilterBefore(new CustomLogoutFilter(logoutService), LogoutFilter.class);

        // 경로별 인가 설정
        http.authorizeHttpRequests(auth -> auth
                .antMatchers("/**").permitAll());  // 테스트를 위해 모든 경로 허용 상태 antMatchers("/**") // 기본 경로는 누구나 접근 가능 antMatchers("/")
                // .anyRequest().authenticated());  // 나머지 경로는 인증된 사용자만 접근 가능

        // 세션 관리 설정 : STATELESS
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        return http.build();
    }   

    // CORS 설정 추가
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://192.168.0.6:5173");	
        corsConfiguration.addAllowedOrigin("http://localhost:5173");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }
    
}
