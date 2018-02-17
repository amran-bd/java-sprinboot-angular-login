package com.amran.loginregdemo.controller;

import com.amran.loginregdemo.persistence.model.User;
import com.amran.loginregdemo.security.ActiveUserStore;
import com.amran.loginregdemo.service.IUserService;
import com.amran.loginregdemo.util.OnRegistrationCompleteEvent;
import com.amran.loginregdemo.web.dto.UserRegisterDto;
import com.amran.loginregdemo.web.util.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.Serializable;

/**
 * @Project:LoginRegDemoExample
 * @author:Md.Amran-Hossain
 * @Date:11/02/2018
 */
@Controller
public class BaseController implements Serializable{
    public static  final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    private ActiveUserStore activeUserStore;

    @Autowired
    private IUserService userService;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public BaseController() {
    }

    @RequestMapping("/")
    public String index(ModelMap modal) {
        modal.addAttribute("title","Login Demo");
        return "index";
    }

    // Registration

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    @ResponseBody
    public CommonResponse registerUserAccount(@RequestBody @Valid final UserRegisterDto userRegisterDto, final HttpServletRequest request) {
        LOGGER.debug("Registering user account with information: {}", userRegisterDto);

        if (userService.isUserExist(userRegisterDto)) {
            LOGGER.error("Unable to create. A User with name {} already exist", userRegisterDto.getEmail());
            return new CommonResponse(HttpStatus.CONFLICT,"Unable to create. A User already exist.");
        }
        final User registered = userService.registerNewUserAccount(userRegisterDto);
        return new CommonResponse(HttpStatus.CREATED,"User create success!");
    }

    private String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
