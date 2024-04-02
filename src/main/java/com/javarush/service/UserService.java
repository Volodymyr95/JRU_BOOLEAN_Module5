package com.javarush.service;

import com.javarush.dto.NewUserDto;
import com.javarush.dto.UserDto;
import com.javarush.dto.UserInfoDto;
import com.javarush.entity.User;
import com.javarush.exceptions.UserNotFoundException;
import com.javarush.exceptions.UserNotValidExceptions;
import com.javarush.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public List<UserDto> getUsers() {
        return userRepository.getAll()
                .stream()
                .map(u -> modelMapper.map(u, UserDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void save(NewUserDto user) {
        if (user.getEmail().isEmpty()) {
            throw new UserNotValidExceptions("Email cannot be empty!");
        }
        userRepository.save(modelMapper.map(user, User.class));
    }

    @Transactional
    public UserInfoDto getUserById(long id) {
        return modelMapper.map(userRepository.getById(id).orElseThrow(() -> new UserNotFoundException()), UserInfoDto.class);
    }

    @Transactional
    public void deleteUser(long id) {
        isUserExist(id);
        userRepository.delete(id);
    }

    @Transactional
    public List<UserDto> getUsersByFirstOrLastName(String firstName, String lastName) {
        return userRepository.getByFirstOrLastName(firstName, lastName)
                .stream()
                .map(u -> modelMapper.map(u, UserDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void update(UserInfoDto user) {
        userRepository.update(modelMapper.map(user, User.class));
    }

    @Transactional
    public UserDto getByEmail(String email) {
        return modelMapper.map(userRepository.getByEmail(email).orElseThrow(() -> new UserNotFoundException()), UserDto.class);
    }

    private void isUserExist(long id) {
        if (userRepository.getById(id) == null) {
            throw new UserNotFoundException();
        }
    }
}






