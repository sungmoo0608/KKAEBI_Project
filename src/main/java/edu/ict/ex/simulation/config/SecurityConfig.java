package edu.ict.ex.simulation.config;

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

import edu.ict.ex.simulation.service.CustomUserDetailsService;

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
	      
		http.authorizeHttpRequests()
		.antMatchers("/**")
		.permitAll();

		//로그인 폼 커스텀 마이징
        http.formLogin()
        	.loginPage("/login")  //loginPage() 는 말그대로 로그인할 페이지 url 이고
            .usernameParameter("userid")
            .passwordParameter("password")
            .failureUrl("/login?error=true") // 로그인 실패 시 에러 페이지
            .defaultSuccessUrl("/"); // 로그인 후 loginInfo로 리디렉션

        
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {        
		return new BCryptPasswordEncoder();
	}
	
}
