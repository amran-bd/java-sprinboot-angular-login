package com.amran.loginregdemo.web.mapper;

import com.amran.loginregdemo.persistence.model.User;
import com.amran.loginregdemo.web.dto.UserDto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-03-03T14:08:19+0600",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_65 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto userToUserDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( entity.getId() );
        userDto.setUsername( entity.getUsername() );
        userDto.setFirstName( entity.getFirstName() );
        userDto.setLastName( entity.getLastName() );
        userDto.setEmail( entity.getEmail() );
        userDto.setMobile( entity.getMobile() );

        return userDto;
    }
}
