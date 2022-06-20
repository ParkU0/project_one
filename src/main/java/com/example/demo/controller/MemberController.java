package com.example.demo.controller;

import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


//@Component 어노테이션 = 스프링 빈으로 자동등록
//@Controller 가 자동 등록 된 이유 = @Controller 에 @Component 가 포함되어 있기 때문이다
@Controller
public class MemberController {

    private final MemberService memberService;

    //의존관계주입
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
