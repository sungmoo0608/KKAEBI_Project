package edu.ict.ex.login.dto.respose.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import edu.ict.ex.login.common.ResponseCode;
import edu.ict.ex.login.common.ResponseMessage;
import lombok.Getter;

@Getter
public class SignUpResponseDto extends ResponseDto {

    private SignUpResponseDto () {
        super();
    }

    public static ResponseEntity<SignUpResponseDto> succes () {
        SignUpResponseDto responseBody = new SignUpResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    
    public static ResponseEntity<ResponseDto> duplicateId () {
        ResponseDto responseBody = new ResponseDto(ResponseCode.DUPLICATE_ID, ResponseMessage.DUPLICATE_ID);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> certificationFail () {
        ResponseDto responseBody = new ResponseDto(ResponseCode.CERTIFICATION_FAIL, ResponseMessage.CERTIFICATION_FAIL);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
    }
}
