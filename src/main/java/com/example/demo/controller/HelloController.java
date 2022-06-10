package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //컨트롤러 선언
public class HelloController {

    @GetMapping("hello")  // 스프링 부트 템플릿엔진 기본 viewName을 GET으로 넘어온 값과 매핑 resources:templates/{hello}.html
    public String hello(Model model){
        model.addAttribute("data", "hello!");   //data 값을 hello!로 셋팅
        return "hello"; //hello를 리턴
    }

    //MVC와 템플릿 엔진
    @GetMapping("hello-mvc")    //view에게 던진다.
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
    
    //API
    //@ResponseBody 사용 시 viewResolver 대신 HttpMessageConverter 동작
    // 기본 문자 처리 : StringHttpMessageConverter
    // 기본 객체 처리 : MappingJackson2HttpMessageConverter
    //byte 처리 등등 여러 HttpMessageConverter 기본 등록되어 있음
    @GetMapping("hello-spring")
    @ResponseBody   //http에서의 body에 데이터를 직접 쓰겠다는 의미
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody   //객체일 때 json 방식으로 데이터를 만들어서 http에 반환한다
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        //property 접근 방식, javaBean 표준 방식
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
