package com.sc.interview.crudapp.service;

import com.sc.interview.crudapp.dto.UserDto;
import com.sc.interview.crudapp.exception.UserDoesNotExistException;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserDto> getAllUsersWithAddresses();

    UserDto getUserWithAddresses(UUID uuid);

    UserDto create(UserDto userDto);

    UserDto update(UserDto userDto) throws UserDoesNotExistException;

    void delete(UUID uuid) throws UserDoesNotExistException;

}
