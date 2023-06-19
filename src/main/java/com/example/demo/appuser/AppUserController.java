package com.example.demo.appuser;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/")
public class AppUserController {

    @GetMapping(path = "ping")
    public String hello() {
        return "pong";
    }



}
