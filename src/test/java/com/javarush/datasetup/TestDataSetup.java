package com.javarush.datasetup;

import com.javarush.entity.User;
import com.javarush.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class TestDataSetup {

    private final UserRepository userRepository;

    public void setupUserData() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Snow");
        user.setEmail("email@gmail.com");

        userRepository.save(user);
    }
}
