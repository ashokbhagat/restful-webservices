package com.ashok.practice.rest.webservices.controller;

import com.ashok.practice.rest.webservices.domain.Login;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    @GetMapping(path = "/getloginwithoutpassword")
    public MappingJacksonValue getLoginWithoutPassword() {

        Login login = new Login("Ashok", "123$$%%", "9152");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("username", "contact");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("ignorepwdfilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(login);
        mapping.setFilters(filterProvider);

        return mapping;
    }

    @GetMapping(path = "/getloginwithoutcontact")
    public MappingJacksonValue getLoginWithoutContact() {

        Login login = new Login("Ashok", "123$$%%", "9152");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("username", "password");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("ignorepwdfilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(login);
        mapping.setFilters(filterProvider);

        return mapping;
    }
}
