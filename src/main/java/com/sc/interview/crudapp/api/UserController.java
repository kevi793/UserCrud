package com.sc.interview.crudapp.api;

import com.sc.interview.crudapp.dto.UserDto;
import com.sc.interview.crudapp.exception.UserDoesNotExistException;
import com.sc.interview.crudapp.service.UserService;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * get all users with their addresses.
     */
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> get() {
        List<UserDto> userDtoList = this.userService.getAllUsersWithAddresses();
        return ResponseEntity.ok(userDtoList);
    }

    /**
     * create a user.
     */
    @PostMapping("/users")
    public ResponseEntity<UserDto> create(@Valid @RequestBody UserDto userDto) {
        UserDto userCreated = this.userService.create(userDto);
        return ResponseEntity.ok(userCreated);
    }

    /**
     * Update a user
     * @param id Id of the user to update
     * @param userDto Dto having updated values.
     * @return updated userDto
     * @throws UserDoesNotExistException
     */
    @PutMapping("/users/{id}")
    public ResponseEntity update(
            @RequestParam(name = "id") final UUID id,
            @Valid @RequestBody UserDto userDto) throws UserDoesNotExistException {

        if (id != userDto.getId()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        UserDto userUpdated = this.userService.update(userDto);
        return ResponseEntity.ok(userUpdated);
    }

    /**
     *
     * @param id of the user to delete.
     * @return void
     * @throws UserDoesNotExistException
     */
    @DeleteMapping("/users/{id}")
    public ResponseEntity delete(
            @RequestParam(name = "id") final UUID id
    ) throws UserDoesNotExistException {
        this.userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
