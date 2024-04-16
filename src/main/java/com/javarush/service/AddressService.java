package com.javarush.service;

import com.javarush.dto.AddressDto;
import com.javarush.dto.NewAddressDto;
import com.javarush.entity.Address;
import com.javarush.exceptions.AddressNotFoundException;
import com.javarush.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public void createAddress(NewAddressDto addressDto) {
        addressRepository.create(modelMapper.map(addressDto, Address.class));
    }

    public List<AddressDto> getAll() {
        return addressRepository.findAll()
                .stream()
                .map(a -> modelMapper.map(a, AddressDto.class))
                .collect(Collectors.toList());

    }

    public void update(AddressDto addressDto) {
        Address address = modelMapper.map(addressDto, Address.class);
        addressRepository.update(address);
    }

    public void delete(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException());
        addressRepository.delete(address);
    }

    public AddressDto getById(Long addressId) {
        Address address = addressRepository.findById(addressId).orElseThrow(() -> new AddressNotFoundException());
        return modelMapper.map(address, AddressDto.class);
    }
}
