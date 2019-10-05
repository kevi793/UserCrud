package com.sc.interview.crudapp.service.impl;

import com.sc.interview.crudapp.dto.AddressDto;
import com.sc.interview.crudapp.entity.Address;
import com.sc.interview.crudapp.entity.User;
import com.sc.interview.crudapp.exception.AddressDoesNotExistException;
import com.sc.interview.crudapp.exception.UserDoesNotExistException;
import com.sc.interview.crudapp.mapper.EntityMapper;
import com.sc.interview.crudapp.repository.AddressRepository;
import com.sc.interview.crudapp.repository.UserRepository;
import com.sc.interview.crudapp.service.AddressService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private UserRepository userRepository;
    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(UserRepository userRepository,
                              AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<AddressDto> get(int userId) throws UserDoesNotExistException {

        Optional<User> user = this.userRepository.findById(userId);

        if (!user.isPresent()) {
            throw new UserDoesNotExistException("Cannot find addresses for User which does not exist");
        }

        List<Address> addressList = this.addressRepository.getByUser(userId);
        return addressList
                .stream()
                .map(EntityMapper.Instance::toAddressDto)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDto create(int userId, AddressDto addressDto) throws UserDoesNotExistException {
        Optional<User> user = this.userRepository.findById(userId);

        if (!user.isPresent()) {
            throw new UserDoesNotExistException("Cannot add address for User which does not exist");
        }

        Address addressToAdd = EntityMapper.Instance.toAddress(addressDto);
        addressToAdd.setUser(user.get());
        Address addressCreated = this.addressRepository.save(addressToAdd);
        return EntityMapper.Instance.toAddressDto(addressCreated);
    }

    @Override
    public AddressDto update(AddressDto addressDto) throws AddressDoesNotExistException {
        Optional<Address> addressToUpdateOptional =
                    this.addressRepository.findById(addressDto.getId());

        if (!addressToUpdateOptional.isPresent()) {
            throw new AddressDoesNotExistException("Cannot update address which does not exist");
        }

        Address addressToUpdate = addressToUpdateOptional.get();
        addressToUpdate.setAddressType(addressDto.getAddressType());
        addressToUpdate.setCity(addressDto.getCity());
        addressToUpdate.setCountryCode(addressDto.getCountryCode());
        addressToUpdate.setLine1(addressDto.getLine1());
        addressToUpdate.setLine2(addressDto.getLine2());
        addressToUpdate.setLine3(addressDto.getLine3());
        addressToUpdate.setLine4(addressDto.getLine4());
        addressDto.setState(addressDto.getState());
        addressDto.setZipcode(addressDto.getZipcode());

        Address addressUpdated = this.addressRepository.save(addressToUpdate);
        return EntityMapper.Instance.toAddressDto(addressUpdated);
    }

    @Override
    public void delete(int id) throws AddressDoesNotExistException {
        Optional<Address> addressToDelete = this.addressRepository.findById(id);
        if (!addressToDelete.isPresent()) {
            throw new AddressDoesNotExistException("Cannot delete address which does not exist.");
        }

        this.addressRepository.delete(addressToDelete.get());
    }
}
