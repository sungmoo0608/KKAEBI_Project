package edu.ict.ex.login.dto.respose.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;

@Getter
public class CheckCertificationResponseDto extends ResponseDto {
    
    private CheckCertificationResponseDto () {
        super();
    }

    public static ResponseEntity<CheckCertificationResponseDto> success() {
        CheckCertificationResponseDto reponseBody = new CheckCertificationResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(reponseBody);
    }

    public static ResponseEntity<ResponseDto> certificationFail () {
        ResponseDto reponseBody = new ResponseDto();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(reponseBody);
    }


}
