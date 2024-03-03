package dev.backend.moduleapi.exceptionHandler;

import dev.backend.moduleapi.exception.CustomException;
import dev.backend.moduleapi.response.CommonResponse;
import dev.backend.modulecommon.enums.CodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class) // 이 exception이 터지면 client에게 전해지는 응답
    public CommonResponse handlerCustomException(CustomException e){
        return CommonResponse.builder()
                .returnCode(e.getReturnCode())
                .returnMessage(e.getReturnMessage())
                .build();
    }

    @ExceptionHandler(Exception.class) //못잡은 exception을 여기서 처리
    public CommonResponse handlerException(Exception e){
        return CommonResponse.builder()
                .returnCode(CodeEnum.UNKNOWN_ERROR.getCode())
                .returnMessage(CodeEnum.UNKNOWN_ERROR.getMessage())
                .build();
    }
}
