package com.amran.loginregdemo.config;

import com.amran.loginregdemo.persistence.model.User;
import com.amran.loginregdemo.persistence.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Project:LoginRegDemoExample
 * @author:Md.Amran-Hossain
 * @Date:11/02/2018
 */
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LOGGER.info("In SetupDataLoader.onApplicationEvent() method");
        if (alreadySetup) {
            return;
        }
        final User user = new User();
        user.setFirstName("Amran");
        user.setLastName("Hossain");
        user.setPassword(passwordEncoder.encode("Test126345!"));
        user.setEmail("amrancse930@gmail.com");
        user.setUsername("amrancse930@gmail.com");
        user.setMobile("01817126345");
        user.setUserStatus("A");
        userRepository.save(user);

        alreadySetup = true;
        LOGGER.info("In SetupDataLoader.onApplicationEvent() Initial Data loading finished.");
    }
}
