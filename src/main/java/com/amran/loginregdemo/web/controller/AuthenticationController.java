package com.amran.loginregdemo.web.controller;


import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project:LoginRegDemoExample
 * @author:Md.Amran-Hossain
 * @Date:01/03/2018
 */
@RestController
@RequestMapping(path = "/auth",produces = MediaType.APPLICATION_JSON_VALUE )
public class AuthenticationController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private Environment environment;

    @Autowired
    private Gson gson;
}
