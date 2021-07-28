package com.ashok.practice.rest.webservices.controller;

import com.ashok.practice.rest.webservices.domain.Login;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    @GetMapping(path="/getLogin")
    public Login getLogin(){
        return new Login("Ashok", "123$$%%");
    }
}
