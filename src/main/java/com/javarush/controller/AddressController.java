package com.javarush.controller;

import com.javarush.dto.AddressDto;
import com.javarush.dto.NewAddressDto;
import com.javarush.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Validated NewAddressDto addressDto) {
        addressService.createAddress(addressDto);
    }

    @GetMapping
    public List<AddressDto> getAll() {
        return addressService.getAll();
    }

    @PutMapping
    public void update(@RequestBody AddressDto addressDto) {
        addressService.update(addressDto);
    }

    @DeleteMapping("/{addressId}")
    public void delete(@PathVariable Long addressId) {
        addressService.delete(addressId);
    }

    @GetMapping("/{addressId}")
    public AddressDto getById(@PathVariable Long addressId) {
        return addressService.getById(addressId);
    }
}
