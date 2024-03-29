package com.javarush.service;

import com.javarush.entity.User;
import com.javarush.repository.UserAddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserAddressService {

    private final UserAddressRepository userAddressRepository;

    public UserAddressService(UserAddressRepository userAddressRepository) {
        this.userAddressRepository = userAddressRepository;
    }

    @Transactional
    public List<User> getUsersByCityName(String city) {
        return userAddressRepository.getUsersByCity(city);
    }

    @Transactional
    public List<User> getUsersByStreet(String street) {
        return userAddressRepository.getUsersByStreet(street);
    }

    @Transactional
    public List<User> getUsersByCityAndStreet(String city, String street) {
        return userAddressRepository.getUsersByCityAndStreet(city, street);
    }
}
