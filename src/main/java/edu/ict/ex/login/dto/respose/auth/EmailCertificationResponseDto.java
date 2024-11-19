package edu.ict.ex.login.dto.respose.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import edu.ict.ex.login.common.ResponseCode;
import edu.ict.ex.login.common.ResponseMessage;
import lombok.Getter;

@Getter
public class EmailCertificationResponseDto extends ResponseDto {
    
    private EmailCertificationResponseDto() {
        super();
    }

    public static ResponseEntity<EmailCertificationResponseDto> success() {
        EmailCertificationResponseDto responseBody = new EmailCertificationResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> duplicateId() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.DUPLICATE_ID, ResponseMessage.DUPLICATE_ID);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> mailSendFail() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.MAIL_FAIL, ResponseMessage.MAIL_FAIL);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

}
