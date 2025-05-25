package com.iwon.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    // index.html 에서 호출하는 값과 동일
    @GetMapping("hello")
    public String hello(Model model) {
        // 모델 객체에 data:hello!! 추가하기
        model.addAttribute("data", "Controller의 model 값");
        return "hello"; // src/main/resources/templates/hello.html
        // return "ViewName"; -> resources:templates/ +{ViewName}+ .html
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody   // HTTP 프로토콜 body 부분에 데이터를 직접 넣겠다
    public String helloAPI(@RequestParam("name") String name) {
        return "Hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;   // 객체 반환 기본이 json 전달
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
