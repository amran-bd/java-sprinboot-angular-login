package com.amran.loginregdemo.service;

import com.amran.loginregdemo.exception.UserAlreadyExistException;
import com.amran.loginregdemo.persistence.model.User;
import com.amran.loginregdemo.persistence.repository.UserRepository;
import com.amran.loginregdemo.web.dto.UserRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Project:LoginRegDemoExample
 * @author:Md.Amran-Hossain
 * @Date:11/02/2018
 */
@Service("userService")
@Transactional
public class UserService implements IUserService{

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerNewUserAccount(UserRegisterDto registerUserDto) throws UserAlreadyExistException {
        final User user = new User();
        user.setFirstName(registerUserDto.getFirstName());
        user.setLastName(registerUserDto.getLastName());
        user.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
        user.setEmail(registerUserDto.getEmail());
        user.setUsername(registerUserDto.getEmail());
        user.setUserStatus("I");
        return repository.save(user);
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public User findByName(String name) {
        return repository.findByUsername(name);
    }

    @Override
    public void saveUser(User user) {
        repository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        repository.delete(id);
    }

    @Override
    public void deleteAllUsers() {
        repository.deleteAll();
    }

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public boolean isUserExist(UserRegisterDto userRegisterDto) {
        return false;
    }
}
