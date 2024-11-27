package edu.ict.ex.login.filter;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class JWTFilter extends OncePerRequestFilter {
	
	private final JWTUtil jwtUtil;

    private boolean isAccessTokenValid(String accessToken) throws ExpiredJwtException{
        return !jwtUtil.isExpired(accessToken) && "access".equals(jwtUtil.getCategory(accessToken));
    }

    private void authenticateUser(String accessToken) {
        CustomUserDetails customUserDetails = new CustomUserDetails(edu.ict.ex.login.entity.UserEntity.builder()
                .username(jwtUtil.getUsername(accessToken))
                .id(jwtUtil.getUserId(accessToken))
                .role(jwtUtil.getRole(accessToken))
                .build());

        Authentication authToken = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);

    }

    private void setResponseStatus(HttpServletResponse httpResponse, HttpStatus statusCode, String message) throws IOException {
        PrintWriter writer = httpResponse.getWriter();
        writer.write("{\"status\":" + statusCode + ", \"message\":\"" + message + "\"}");
        httpResponse.setStatus(statusCode.value());
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        String accessToken = req.getHeader("Authorization");
        String path = req.getRequestURI();
        log.info("Access token 접수:{} ", accessToken);

        if ("/refresh".equals(path)) {
            filterChain.doFilter(req, res);
            return;
        }
        if ( accessToken == null || accessToken.equals("undefined") ){
            log.info("NULL OR UNDEFINED");
            filterChain.doFilter(req, res);
            return;
        }

        try{

            if (!isAccessTokenValid(accessToken)){
                setResponseStatus(res, HttpStatus.UNAUTHORIZED, "Invalid Token.");
            }

            authenticateUser(accessToken);
            filterChain.doFilter(req, res);

        }catch(ExpiredJwtException e){
            setResponseStatus(res, HttpStatus.UNAUTHORIZED, "Expired Token.");
        }catch(SignatureException e){
            setResponseStatus(res, HttpStatus.UNAUTHORIZED, "Signature Error.");
        }catch(Exception e){
            setResponseStatus(res, HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL SERVER ERROR");
            e.printStackTrace();
        }

    }


}
