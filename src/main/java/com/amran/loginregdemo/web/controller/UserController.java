package com.amran.loginregdemo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;
import java.util.Locale;

/**
 * @Project:LoginRegDemoExample
 * @author:Md.Amran-Hossain
 * @Date:11/02/2018
 */
@Controller
public class UserController implements Serializable{

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String homepage(){
        return "index";
    }
}
