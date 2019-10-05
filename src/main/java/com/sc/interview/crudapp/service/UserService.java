package com.sc.interview.crudapp.service;

import com.sc.interview.crudapp.dto.UserDto;
import com.sc.interview.crudapp.exception.UserDoesNotExistException;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsersWithAddresses();

    UserDto getUserWithAddresses(int id) throws UserDoesNotExistException;

    UserDto create(UserDto userDto);

    UserDto update(UserDto userDto) throws UserDoesNotExistException;

    void delete(int id) throws UserDoesNotExistException;

}
