package com.javarush.controller;

import com.javarush.dto.UserDto;
import com.javarush.service.UserAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "/users/user/address")
@RequiredArgsConstructor
public class UserAddressController {

    private final UserAddressService userAddressService;

    @GetMapping(value = "/city/{city}")
    public List<UserDto> getAllByCity(@PathVariable String city) {
        return userAddressService.getUsersByCityName(city);
    }

    @GetMapping(value = "/city/street/{street}")
    public List<UserDto> getByStreet(@PathVariable String street) {
        return userAddressService.getUsersByStreet(street);
    }

    @GetMapping(value = "/city/street/{street}/number/{streetNumber}")
    public List<UserDto> getByStreetAndStreetNumber(@PathVariable String street, @PathVariable String streetNumber) {
        return userAddressService.getUsersByStreetAndStreetNumber(street, streetNumber);
    }

    @GetMapping(value = "/city/{city}/street/{street}")
    public List<UserDto> getUsersByCityAndStreet(@PathVariable String city, @PathVariable String street) {
        return userAddressService.getUsersByCityAndStreet(city, street);
    }

    @PutMapping(value = "/{userId}/street/{street}/number/{streetNumber}")
    public void assignUserToStreet(@PathVariable Long userId, @PathVariable String street, @PathVariable String streetNumber) {
        userAddressService.assignUserToAddress(userId, street, streetNumber);
    }

    //TODO : Add endpoint to assign address to user using addressId and userId
}
