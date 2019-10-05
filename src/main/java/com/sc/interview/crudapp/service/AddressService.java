package com.sc.interview.crudapp.service;

import com.sc.interview.crudapp.dto.AddressDto;
import com.sc.interview.crudapp.exception.AddressDoesNotExistException;
import com.sc.interview.crudapp.exception.UserDoesNotExistException;

import java.util.List;
import java.util.UUID;

public interface AddressService {

    List<AddressDto> get(UUID userId) throws UserDoesNotExistException;

    AddressDto create(UUID userId, AddressDto addressDto) throws UserDoesNotExistException;

    AddressDto update(AddressDto addressDto) throws AddressDoesNotExistException;

    void delete(UUID id) throws AddressDoesNotExistException;

}
