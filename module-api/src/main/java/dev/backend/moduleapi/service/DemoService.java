package dev.backend.moduleapi.service;

import dev.backend.moduleapi.exception.CustomException;
import dev.backend.modulecommon.domain.Member;
import dev.backend.modulecommon.enums.CodeEnum;
import dev.backend.modulecommon.repositories.MemberRepository;
import dev.backend.modulecommon.service.CommonDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class DemoService {

    @Value("${profile-name}")
    private String name;

    private final MemberRepository memberRepository;

    public String save(){

        memberRepository.save(Member.builder().name(Thread.currentThread().getName()).build());
        return "Save";
    }

    public String find(){
        int size = memberRepository.findAll().size();
        System.out.println("db size: " + size);
        return "Find";
    }

    public String exception(){

        if(true){
            throw new CustomException(CodeEnum.UNKNOWN_ERROR.getCode(), CodeEnum.UNKNOWN_ERROR.getMessage());
        }

        return "exception";
    }
}
