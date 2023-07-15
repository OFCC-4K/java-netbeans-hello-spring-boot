package com.overflow.hellospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Hello !!");

        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);

        return "hello-template";
    }

    @ResponseBody
    @GetMapping("hello-spring")
    public String helloSpring(@RequestParam("name") String name) {
        return "안녕, " + name;
    }

    @ResponseBody
    @GetMapping("hello-api")
    public Hello helloApi(@RequestParam(value = "name") String name) {
        Hello hello = new Hello();

        hello.setName(name);

        return hello;
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
