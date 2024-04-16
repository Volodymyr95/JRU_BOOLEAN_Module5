package com.javarush.service;

import com.javarush.dto.UserDto;
import com.javarush.entity.Address;
import com.javarush.entity.User;
import com.javarush.exceptions.AddressNotFoundException;
import com.javarush.exceptions.UserNotFoundException;
import com.javarush.repository.AddressRepository;
import com.javarush.repository.UserAddressRepository;
import com.javarush.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserAddressService {

    private final UserAddressRepository userAddressRepository;
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public List<UserDto> getUsersByCityName(String city) {
        return userAddressRepository.getUsersByCity(city)
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<UserDto> getUsersByStreet(String street) {
        return userAddressRepository.getUsersByStreet(street)
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<UserDto> getUsersByStreetAndStreetNumber(String street, String streetNumber) {
        return userAddressRepository.getUsersByStreetAndStreetNumber(street, streetNumber)
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<UserDto> getUsersByCityAndStreet(String city, String street) {
        return userAddressRepository.getUsersByCityAndStreet(city, street)
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void assignUserToAddress(Long id, String street, String streetNumber) {
        User user = userRepository.getById(id).orElseThrow(() -> new UserNotFoundException());
        Address addressByStreetAndNumber = addressRepository
                .findByStreetAndNumber(street, streetNumber).orElseThrow(() -> new AddressNotFoundException());

        user.setAddress(addressByStreetAndNumber);
        userRepository.update(user);

    }
}
