package com.javarush.dto;

import lombok.Data;

@Data
public class UserInfoDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private AddressDto address;

}
