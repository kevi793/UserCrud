package com.sc.interview.crudapp.service.impl;

import com.sc.interview.crudapp.dto.UserDto;
import com.sc.interview.crudapp.entity.User;
import com.sc.interview.crudapp.exception.UserDoesNotExistException;
import com.sc.interview.crudapp.mapper.EntityMapper;
import com.sc.interview.crudapp.repository.UserRepository;
import com.sc.interview.crudapp.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAllUsersWithAddresses() {
        List<User> users = this.userRepository.findUsersWithAddresses();
        return users.stream().map(EntityMapper.Instance::toUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserWithAddresses(int id) throws UserDoesNotExistException {
        User user = this.userRepository.findUserWithAddresses(id);

        if (user == null) {
            throw new UserDoesNotExistException("User does not exist.");
        }

        return EntityMapper.Instance.toUserDto(user);
    }

    @Override
    public UserDto create(UserDto userDto) {
        User userToCreate = EntityMapper.Instance.toUser(userDto);
        User userCreated = this.userRepository.save(userToCreate);
        return EntityMapper.Instance.toUserDto(userCreated);
    }

    @Override
    public UserDto update(UserDto userDto) throws UserDoesNotExistException {
        Optional<User> userToUpdateOptional = this.userRepository.findById(userDto.getId());
        if (!userToUpdateOptional.isPresent()) {
            throw new UserDoesNotExistException(
                        String.format("User does not exist with Id: %s", userDto.getId()));
        }

        User userToUpdate = userToUpdateOptional.get();
        userToUpdate.setGender(userDto.getGender());
        userToUpdate.setCountryOfBirth(userDto.getCountryOfBirth());
        userToUpdate.setCountryOfResidence(userDto.getCountryOfResidence());
        userToUpdate.setCustomerSegment(userDto.getCustomerSegment());
        userToUpdate.setDob(userDto.getDob());
        userToUpdate.setFirstName(userDto.getFirstName());
        userToUpdate.setMiddleName(userDto.getMiddleName());
        userToUpdate.setLastName(userDto.getLastName());
        userToUpdate.setMobile(userDto.getMobile());

        User userSaved = this.userRepository.save(userToUpdate);
        return EntityMapper.Instance.toUserDto(userSaved);
    }

    @Override
    public void delete(int id) throws UserDoesNotExistException {
        Optional<User> userToDelete = this.userRepository.findById(id);
        if (!userToDelete.isPresent()) {
            throw new UserDoesNotExistException("Cannot delete user which does not exist.");
        }

        this.userRepository.delete(userToDelete.get());
    }
}
