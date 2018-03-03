package com.amran.loginregdemo.web.controller;

import com.amran.loginregdemo.persistence.model.User;
import com.amran.loginregdemo.service.IUserService;
import com.amran.loginregdemo.web.dto.UserDto;
import com.amran.loginregdemo.web.dto.UserRegisterDto;
import com.amran.loginregdemo.web.error.ApiError;
import com.amran.loginregdemo.web.mapper.UserMapper;
import com.google.gson.Gson;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Locale;

/**
 * @Project:LoginRegDemoExample
 * @author:Md.Amran-Hossain
 * @Date:11/02/2018
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/user",produces = MediaType.APPLICATION_JSON_VALUE )
public class UserController{
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserService userService;

    @Autowired
    private Environment environment;

    @Autowired
    private Gson gson;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String home(){
        return gson.toJson("Hello World!");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getUser(@PathVariable("id") String id) {
        LOGGER.debug("Get User account information: {}", id);
        final User user = userService.findById(Long.parseLong(id));
        UserMapper userMapper = Mappers.getMapper(UserMapper.class);
        final UserDto userDto = userMapper.userToUserDto(user);
        return new ResponseEntity<Object>(userDto, new HttpHeaders(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/createUser",  method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserRegisterDto userRegisterDto){
        LOGGER.debug("User  create: {}", userRegisterDto);

        final ApiError apiError = new ApiError(HttpStatus.EXPECTATION_FAILED, "User creation failed.", "error occurred");
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }

}
