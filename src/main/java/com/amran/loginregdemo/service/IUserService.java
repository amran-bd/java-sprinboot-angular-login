package com.amran.loginregdemo.service;

import com.amran.loginregdemo.exception.UserAlreadyExistException;
import com.amran.loginregdemo.persistence.model.User;
import com.amran.loginregdemo.web.dto.UserRegisterDto;

import java.util.List;

/**
 * @Project:LoginRegDemoExample
 * @author:Md.Amran-Hossain
 * @Date:11/02/2018
 */
public interface IUserService {

    User registerNewUserAccount(UserRegisterDto registerUserDto) throws UserAlreadyExistException;

    User findById(Long id);

    User findByName(String name);

    void saveUser(User user);

    void deleteUserById(Long id);

    void deleteAllUsers();

    List<User> findAllUsers();

    boolean isUserExist(UserRegisterDto userRegisterDto);

}
