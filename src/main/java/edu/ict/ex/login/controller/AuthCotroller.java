package edu.ict.ex.login.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ict.ex.login.dto.requset.auth.CheckCertificationRequestDto;
import edu.ict.ex.login.dto.requset.auth.EmailCertificationRequestDto;
import edu.ict.ex.login.dto.requset.auth.IdCheckRequestDto;
import edu.ict.ex.login.dto.requset.auth.SignUpRequestDto;
import edu.ict.ex.login.dto.respose.auth.CheckCertificationResponseDto;
import edu.ict.ex.login.dto.respose.auth.EmailCertificationResponseDto;
import edu.ict.ex.login.dto.respose.auth.IdCheckResponseDto;
import edu.ict.ex.login.dto.respose.auth.SignUpResponseDto;
import edu.ict.ex.login.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthCotroller {

    private final AuthService authService;

    @PostMapping("/id-check")
    public ResponseEntity<? super IdCheckResponseDto> idCheck (
        @RequestBody @Valid IdCheckRequestDto requestBody
    ) {
        ResponseEntity<? super IdCheckResponseDto> response = authService.idCheck(requestBody);
        return response;
    }
    
    @PostMapping("/email-certification")
    public ResponseEntity<? super EmailCertificationResponseDto> emailCertification (
        @RequestBody @Valid EmailCertificationRequestDto requestBody
    ) {
        ResponseEntity<? super EmailCertificationResponseDto> response = authService.emailCertification(requestBody);
        return response;
    }


    @PostMapping("/check-certification")
    public ResponseEntity<? super CheckCertificationResponseDto> checkCertification (
        @RequestBody @Valid CheckCertificationRequestDto requestBody
    ) {
        ResponseEntity<? super CheckCertificationResponseDto> response = authService.checkCertification(requestBody);
        return response;
    }  

    @PostMapping("/sign-up")
    public ResponseEntity<? super SignUpResponseDto>signUp(
        @RequestBody @Valid SignUpRequestDto requestBody
    ){
        ResponseEntity<? super SignUpResponseDto> response = authService.signUp(requestBody);
        return response;
    }
}
