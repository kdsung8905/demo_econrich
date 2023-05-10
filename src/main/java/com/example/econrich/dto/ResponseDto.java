package com.example.econrich.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class ResponseDto<T> {

    private final Integer code; // 성공 : 1, 실패 : -1
    private final String msg;
    private final T data;
}
