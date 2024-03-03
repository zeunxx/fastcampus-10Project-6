package dev.backend.moduleapi.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import dev.backend.modulecommon.enums.CodeEnum;
import lombok.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL) // NULL 값은 보여주지 않음
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> { // 클라이언트 응답 포맷
    private String returnCode;
    private String returnMessage;
    private T info;

    public CommonResponse(CodeEnum codeEnum){
        setReturnCode(codeEnum.getCode());
        setReturnMessage(codeEnum.getMessage());
    }

    public CommonResponse(T info) {
        setReturnCode(CodeEnum.SUCCESS.getCode());
        setReturnMessage(CodeEnum.SUCCESS.getMessage());
        setInfo(info);
    }

    public CommonResponse(CodeEnum codeEnum, T info){
        setReturnCode(codeEnum.getCode());
        setReturnMessage(codeEnum.getMessage());
        setInfo(info);
    }


}
