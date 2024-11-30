package edu.ict.ex.user.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import edu.ict.ex.user.security.CustomUserDetailsService;

@Configuration		//@Component + 설정
@EnableWebSecurity	//필터 등록 = 시큐리티 설정 파일이다 라고 알려주는 역할
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Autowired
    private CustomUserDetailsService customUserDetailsService;


	/* 정적 리소스 폴더 처리 */
	@Override
	public void configure(WebSecurity web) throws Exception {

	}
	
	/* 테스트용 유저 등록 = 인메모리 방식 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService)
			.passwordEncoder(passwordEncoder());

	}
	
	/* 권한 설정 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//우선 CSRF설정을 해제한다.
		//초기 개발시만 해주는게 좋다.
		http.csrf(csrf -> csrf.disable());
		
        // CORS 활성화
        http.cors().configurationSource(corsConfigurationSource());
	      
		http.authorizeHttpRequests()
		.antMatchers("/**")
		.permitAll();

		//로그인 폼 커스텀 마이징
        http.formLogin()
        	.loginPage("/login")  //loginPage() 는 말그대로 로그인할 페이지 url 이고
            .usernameParameter("userid")
            .passwordParameter("password")
            .failureUrl("/login?error=true") // 로그인 실패 시 에러 페이지
            .defaultSuccessUrl("/") // 로그인 후 리디렉션
            .and()
            .exceptionHandling()
            .authenticationEntryPoint((request, response, authException) -> {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "로그인 실패: 인증되지 않은 사용자");
        });
        
        // 로그아웃 설정
        http.logout()
            .logoutUrl("/logout") // 로그아웃을 위한 URL (예: "/logout")
            .logoutSuccessUrl("/") // 로그아웃 성공 후 리디렉션할 URL (예: 홈 화면으로 리디렉션)
            .invalidateHttpSession(true) // 세션 무효화
            .clearAuthentication(true) // 인증 정보를 제거
            .deleteCookies("JSESSIONID"); // 쿠키 삭제 (세션 관련 쿠키)
        
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {        
		return new BCryptPasswordEncoder();
	}
	
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 허용할 출처 추가
        corsConfiguration.addAllowedOrigin("http://192.168.0.6:5173");
        corsConfiguration.addAllowedOrigin("http://localhost:5173");
        // 모든 헤더와 메소드 허용
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true); // 자격 증명 허용 (쿠키 등)
        
        // CORS 설정을 URL 기반으로 등록
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration); // 모든 URL에 대해 적용
        
        return source;
    }
	
	
}
