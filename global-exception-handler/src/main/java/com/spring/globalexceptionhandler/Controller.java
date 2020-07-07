package com.spring.globalexceptionhandler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo/")
public class Controller {
    @GetMapping("add")
    public Object add(String name, Integer age) {
        return null;
    }

    @PostMapping("update")
    public Object update(User user) {
        return null;
    }
}
