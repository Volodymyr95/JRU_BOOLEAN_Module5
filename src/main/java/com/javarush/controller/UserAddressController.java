package com.javarush.controller;

import com.javarush.entity.User;
import com.javarush.service.UserAddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping(value = "/users/user/address")
public class UserAddressController {

    private final UserAddressService userAddressService;

    public UserAddressController(UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    }

    @GetMapping(value = "/city/{city}")
    public List<User> getAllByCity(@PathVariable String city) {
        return userAddressService.getUsersByCityName(city);
    }

    @GetMapping(value = "/city/street/{street}")//city/street/Horodotska   //users/user/userId
    public List<User> getByStreet(@PathVariable String street) {
        return userAddressService.getUsersByStreet(street);
    }

    @GetMapping(value = "/city/{city}/street/{street}")
    public List<User> getUsersByCityAndStreet(@PathVariable String city, @PathVariable String street) {
        return userAddressService.getUsersByCityAndStreet(city, street);
    }
}
