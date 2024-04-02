package com.javarush.controller;

import com.javarush.dto.NewUserDto;
import com.javarush.dto.UserDto;
import com.javarush.dto.UserInfoDto;
import com.javarush.entity.User;
import com.javarush.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(value = "/user/{userId}")
    public UserInfoDto getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping(value = "/user")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody NewUserDto user) {
        userService.save(user);
    }

    @DeleteMapping(value = "/user/{userId}") //users/user/11
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }//URI -

    @GetMapping(value = "/user")// /users/user?firstName=test&lastName=test2&age=10
    public List<UserDto> getByFirstOrLastName(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        return userService.getUsersByFirstOrLastName(firstName, lastName);
    }

    @GetMapping(value = "/user/email/{email}")
    public UserDto getByEmail(@PathVariable String email) {
        return userService.getByEmail(email);
    }

    @PutMapping(value = "/user")
    public void updateUser(@RequestBody UserInfoDto user) {
        userService.update(user);
    }


    /*
    /users/user - Create  POST
    /users/user - Update  PUT
    /users/user/{id) get user by id GET
    /users/user/{id) delete user by id DELETE
     */

    //CRUD - Create,Read,Update,Delete

}
