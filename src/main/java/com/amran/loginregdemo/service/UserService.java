package com.amran.loginregdemo.service;

import com.amran.loginregdemo.exception.UserAlreadyExistException;
import com.amran.loginregdemo.persistence.model.User;
import com.amran.loginregdemo.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Project:LoginRegDemoExample
 * @author:Md.Amran-Hossain
 * @Date:11/02/2018
 */
@Service("userService")
@Transactional
public class UserService implements IUserService{

    @Override
    public User registerNewUserAccount() throws UserAlreadyExistException {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public void deleteAllUsers() {

    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public boolean isUserExist(User user) {
        return false;
    }
}
