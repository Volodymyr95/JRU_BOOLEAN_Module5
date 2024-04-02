package com.javarush.dto;

import lombok.Data;

@Data
public class NewUserDto {
    private String firstName;
    private String lastName;
    private String email;
    private AddressDto address;

}
