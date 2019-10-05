package com.sc.interview.crudapp.mapper;

import com.sc.interview.crudapp.dto.AddressDto;
import com.sc.interview.crudapp.dto.UserDto;
import com.sc.interview.crudapp.entity.Address;
import com.sc.interview.crudapp.entity.User;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class EntityMapper {
    public static final EntityMapper Instance = Mappers.getMapper(EntityMapper.class);

    public abstract UserDto toUserDto(User user);

    public abstract User toUser(UserDto userDto);

    public abstract AddressDto toAddressDto(Address address);

    public abstract Address toAddress(AddressDto addressDto);
}
