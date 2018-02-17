package com.amran.loginregdemo.persistence.config;

import org.hibernate.dialect.MySQLDialect;

/**
 * @Project:LoginRegDemoExample
 * @author:Md.Amran-Hossain
 * @Date:11/02/2018
 */
public class CustomMySQLDialect extends MySQLDialect {

    @Override
    public boolean dropConstraints() {
        return false;
    }
}
