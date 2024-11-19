package edu.ict.ex.login.service;

import org.springframework.http.ResponseEntity;

import edu.ict.ex.login.dto.requset.auth.CheckCertificationRequestDto;
import edu.ict.ex.login.dto.requset.auth.EmailCertificationRequestDto;
import edu.ict.ex.login.dto.requset.auth.IdCheckRequestDto;
import edu.ict.ex.login.dto.requset.auth.SignUpRequestDto;
import edu.ict.ex.login.dto.respose.auth.CheckCertificationResponseDto;
import edu.ict.ex.login.dto.respose.auth.EmailCertificationResponseDto;
import edu.ict.ex.login.dto.respose.auth.IdCheckResponseDto;
import edu.ict.ex.login.dto.respose.auth.SignUpResponseDto;

public interface AuthService {

    ResponseEntity<? super IdCheckResponseDto> idCheck(IdCheckRequestDto dto);
    ResponseEntity<? super EmailCertificationResponseDto> emailCertification(EmailCertificationRequestDto dto);
    ResponseEntity<? super CheckCertificationResponseDto> checkCertification(CheckCertificationRequestDto dto);
    ResponseEntity<? super SignUpResponseDto> signUp (SignUpRequestDto dto);
    
}
