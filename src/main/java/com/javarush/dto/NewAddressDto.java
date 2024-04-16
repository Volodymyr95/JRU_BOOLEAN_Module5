package com.javarush.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class NewAddressDto {
    @Min(value = 4)
    @NotNull(message = "City cannot be empty")
    private String city;
    @Min(value = 4)
    private String street;
    @Min(value = 1)
    private String streetNumber;
}
