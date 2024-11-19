package edu.ict.ex.login.dto.respose.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import edu.ict.ex.login.common.ResponseCode;
import edu.ict.ex.login.common.ResponseMessage;
import lombok.Getter;

@Getter
public class IdCheckResponseDto extends ResponseDto{

    private IdCheckResponseDto() {
        super();
    } 

    public static ResponseEntity<IdCheckResponseDto> success() {
        IdCheckResponseDto responsebody = new IdCheckResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responsebody);
    }

    public static ResponseEntity<ResponseDto> duplicateId() {
        ResponseDto responsebody = new ResponseDto(ResponseCode.DUPLICATE_ID, ResponseMessage.DUPLICATE_ID);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsebody);
    }

}
