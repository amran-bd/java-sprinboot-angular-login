package com.amran.loginregdemo.web.mapper;

import com.amran.loginregdemo.persistence.model.User;
import com.amran.loginregdemo.web.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @Project:LoginRegDemoExample
 * @author:Md.Amran-Hossain
 * @Date:03/03/2018
 */
@Mapper
public interface UserMapper {

    UserDto userToUserDto(User entity);
}

