package com.example.econrich.config;

import com.example.econrich.dto.ResponseDto;
import com.example.econrich.handler.exception.CustomApiException;
import com.sun.net.httpserver.Authenticator;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ApiResponse(responseCode = "201", description = "리소스 생성이 성공적으로 처리됨", content = @Content(schema = @Schema(implementation = ResponseDto.class)))
@ApiResponse(responseCode = "204", description = "리소스 삭제가 성공적으로 처리됨", content = @Content(schema = @Schema(implementation = ResponseDto.class)))
@ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(schema = @Schema(implementation = ResponseDto.class)))
@ApiResponse(responseCode = "401", description = "인증 실패", content = @Content(schema = @Schema(implementation = ResponseDto.class)))
@ApiResponse(responseCode = "403", description = "권한 부족", content = @Content(schema = @Schema(implementation = ResponseDto.class)))
@ApiResponse(responseCode = "404", description = "요청한 리소스를 찾을 수 없음", content = @Content(schema = @Schema(implementation = ResponseDto.class)))
@ApiResponse(responseCode = "500", description = "서버 에러 발생", content = @Content(schema = @Schema(implementation = ResponseDto.class)))
public @interface CustomApiResponse {

}
