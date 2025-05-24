package com.iwon.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        // 모델 객체에 data:hello!! 추가하기
        model.addAttribute("data", "Controller의 model 값");
        return "hello"; // src/main/resources/templates/hello.html
        // return "ViewName"; -> resources:templates/ +{ViewName}+ .html
    }
}
