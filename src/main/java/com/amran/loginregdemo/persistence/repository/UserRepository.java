package com.amran.loginregdemo.persistence.repository;

import com.amran.loginregdemo.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Project:LoginRegDemoExample
 * @author:Md.Amran-Hossain
 * @Date:11/02/2018
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(Long id);

    User findByEmail(String email);

    User findByUsername(String username);

    @Override
    void delete(User user);
}
