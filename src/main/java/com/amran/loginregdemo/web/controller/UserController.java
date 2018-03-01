package com.amran.loginregdemo.web.controller;

import com.amran.loginregdemo.service.IUserService;
import com.amran.loginregdemo.web.dto.UserRegisterDto;
import com.amran.loginregdemo.web.error.ApiError;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Locale;

/**
 * @Project:LoginRegDemoExample
 * @author:Md.Amran-Hossain
 * @Date:11/02/2018
 */
@RestController
@RequestMapping(path = "/",produces = MediaType.APPLICATION_JSON_VALUE )
public class UserController implements Serializable{
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserService userService;

    @Autowired
    private Environment environment;

    @Autowired
    private Gson gson;

    @RequestMapping("/test")
    public String home(){
        return "Hello World!";
    }

    @RequestMapping(value = "/createUser",  method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserRegisterDto userRegisterDto){
        LOGGER.debug("User  create: {}", userRegisterDto);

        final ApiError apiError = new ApiError(HttpStatus.EXPECTATION_FAILED, "User creation failed.", "error occurred");
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }
}
