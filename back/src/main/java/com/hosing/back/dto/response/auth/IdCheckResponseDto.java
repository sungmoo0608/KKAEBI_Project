package com.hosing.back.dto.response.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hosing.back.common.ResponseCode;
import com.hosing.back.common.ResponseMessage;
import com.hosing.back.dto.response.ResponseDto;

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
