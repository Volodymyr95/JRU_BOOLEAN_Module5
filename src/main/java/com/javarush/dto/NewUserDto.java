package com.javarush.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class NewUserDto {
    @NotBlank(message = "First name cannot be blank")
    @Size(min = 2, max = 40, message = "Invalid first name length")
    private String firstName;
    @Pattern(regexp = ".*\\d.", message = "Numbers cannot be in a last name")
    private String lastName;
    @Email(message = "Email is not valid format")
    @Pattern(regexp = ".\\.ru$", message = "Russian warship going f yourself")
    private String email;
    @Min(value = 1, message = "Invalid age value")
    private int age;
    private AddressDto address;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{ ");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
