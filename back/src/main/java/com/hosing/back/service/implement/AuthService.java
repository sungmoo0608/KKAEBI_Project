package com.hosing.back.service.implement;

import org.springframework.http.ResponseEntity;

import com.hosing.back.dto.request.auth.CheckCertificationRequestDto;
import com.hosing.back.dto.request.auth.EmailCertificationRequestDto;
import com.hosing.back.dto.request.auth.IdCheckRequestDto;
import com.hosing.back.dto.request.auth.SignUpRequestDto;
import com.hosing.back.dto.response.auth.CheckCertificationResponseDto;
import com.hosing.back.dto.response.auth.EmailCertificationResponseDto;
import com.hosing.back.dto.response.auth.IdCheckResponseDto;
import com.hosing.back.dto.response.auth.SignUpResponseDto;

public interface AuthService {

    ResponseEntity<? super IdCheckResponseDto> idCheck(IdCheckRequestDto dto);
    ResponseEntity<? super EmailCertificationResponseDto> emailCertification(EmailCertificationRequestDto dto);
    ResponseEntity<? super CheckCertificationResponseDto> checkCertification(CheckCertificationRequestDto dto);
    ResponseEntity<? super SignUpResponseDto> signUp (SignUpRequestDto dto);
    
}
