package com.javarush.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "address", uniqueConstraints = {@UniqueConstraint(columnNames = {"street", "streetNumber"})})
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String street;

    private String streetNumber;

    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<User> users;
}
