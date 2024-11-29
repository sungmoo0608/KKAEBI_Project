package edu.ict.ex.login.mapper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;

import edu.ict.ex.login.dto.CustomOAuth2User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Component
public class CustomLogInSuccessHandler implements AuthenticationSuccessHandler {

	private final UserMapper userMapper;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		// 인증된 사용자의 username을 가져옵니다.
		// String username = ((org.springframework.security.core.userdetails.User)
		// authentication.getPrincipal()).getUsername();
		 //Object principal = authentication.getPrincipal();
		 CustomOAuth2User customUser = (CustomOAuth2User) authentication.getPrincipal();
	      

		 //if ( CustomOAuth2User instanceof  principal) {
		  //      CustomOAuth2User customUser = (CustomOAuth2User) principal;

			// UserRepository를 통해 사용자 정보를 조회합니다. (메서드명 및 쿼리는 필요에 따라 수정)
			// User user = userMapper.findByUsername(username, "일반");
		   String username = customUser.getUsername();

			// 로그인 성공 로그 출력
			log.info("로그인 성공, 사용자: {}", username);

			// 인증된 사용자에 대한 세션을 생성합니다.
			HttpSession session = request.getSession();
			// session.setAttribute("LOGIN_USER", new SessionUser(user));

			// 응답 상태 코드 및 콘텐츠 타입 설정
			response.setStatus(HttpServletResponse.SC_OK);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json;charset=UTF-8");

			// JSON 응답을 작성하여 리다이렉션 URL을 설정
			JsonObject json = new JsonObject();

			json.addProperty("username", username);

			// 응답에 JSON 데이터를 씁니다.
			try (PrintWriter out = response.getWriter()) {
				out.print(json);
			}

		 
	}
}
