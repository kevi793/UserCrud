package com.sc.interview.crudapp.service;

import com.sc.interview.crudapp.dto.AddressDto;
import com.sc.interview.crudapp.exception.AddressDoesNotExistException;
import com.sc.interview.crudapp.exception.UserDoesNotExistException;

import java.util.List;

public interface AddressService {

    List<AddressDto> get(int userId) throws UserDoesNotExistException;

    AddressDto create(int userId, AddressDto addressDto) throws UserDoesNotExistException;

    AddressDto update(AddressDto addressDto) throws AddressDoesNotExistException;

    void delete(int id) throws AddressDoesNotExistException;

}
