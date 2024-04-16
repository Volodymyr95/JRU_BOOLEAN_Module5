package com.javarush.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.config.TestConfig;
import com.javarush.config.WebMvcConfig;
import com.javarush.datasetup.TestDataSetup;
import com.javarush.dto.NewUserDto;
import com.javarush.exceptions.CustomExceptionHandler;
import com.javarush.repository.UserRepository;
import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
//@SpringJUnitWebConfig
//@ContextConfiguration(classes = {TestConfig.class, WebMvcConfig.class})
public class UserControllerTest {

//    @Autowired
//    UserController userController;
//
//    @Autowired
//    TestDataSetup testDataSetup;
//
//    @Autowired
//    CustomExceptionHandler customExceptionHandler;
//
//    @Autowired
//    UserRepository userRepository;
//
//    MockMvc mockMvc;

//    @Before
//    public void setup() {
//        mockMvc = MockMvcBuilders.standaloneSetup(userController)
//                .setControllerAdvice(customExceptionHandler)
//                .build();
//        testDataSetup.setupUserData();
//    }
//
//    @Test
//    @SneakyThrows
//    public void shouldGetAllUsers() {
//        mockMvc.perform(MockMvcRequestBuilders.get("/users/user"))
//                .andExpect(status().is(200));
//    }
//
//    @Test
//    @SneakyThrows
//    public void shouldDeleteWhenIdIsNotExist() {
//        mockMvc.perform(MockMvcRequestBuilders.delete("/users/user/2"))
//                .andExpect(status().is(404));
//    }
//
//    @Test
//    @SneakyThrows
//    public void shouldCreateUser() {
//        String json = "{\n" +
//                "  \"firstName\": \"Test\",\n" +
//                "  \"lastName\": \"User\",\n" +
//                "  \"email\": \"max.277@gmail.com\",\n" +
//                "  \"age\": 0,\n" +
//                "  \"address\": {\n" +
//                "    \"city\": \"London\",\n" +
//                "    \"street\": \"London1\"\n" +
//                "  }\n" +
//                "}";
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/users/user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(json)
//        ).andExpect(status().is(201));
//    }
//
//    @Test
//    @SneakyThrows
//    public void shouldCreateUserWithInvalidEmail() {
//        String json = "{\n" +
//                "  \"firstName\": \"Test\",\n" +
//                "  \"lastName\": \"User\",\n" +
//                "  \"email\": \"max\",\n" +
//                "  \"age\": 0,\n" +
//                "  \"address\": {\n" +
//                "    \"city\": \"London\",\n" +
//                "    \"street\": \"London1\"\n" +
//                "  }\n" +
//                "}";
//
//        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.post("/users/user")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json)
//                ).andExpect(status().is(400))
//                .andReturn().getResponse();
//
//        String errorMessage = response.getErrorMessage();
//        System.out.println(errorMessage);
//    }


}