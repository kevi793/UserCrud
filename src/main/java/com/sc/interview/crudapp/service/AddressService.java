package com.sc.interview.crudapp.service;

import com.sc.interview.crudapp.dto.AddressDto;

import java.util.List;
import java.util.UUID;

public interface AddressService {

    List<AddressDto> get(UUID userId);

    AddressDto create(UUID userId, AddressDto addressDto);

    AddressDto update(UUID userId, AddressDto addressDto);

    void delete(UUID id);

}
