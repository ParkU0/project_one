package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //컨트롤러 선언
public class HelloController {

    @GetMapping("hello")  // 스프링 부트 템플릿엔진 기본 viewName을 GET으로 넘어온 값과 매핑 resources:templates/{hello}.html
    public String hello(Model model){
        model.addAttribute("data", "hello!");   //data 값을 hello!로 셋팅
        return "hello"; //hello를 리턴
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

}
