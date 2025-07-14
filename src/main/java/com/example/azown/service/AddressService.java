package com.example.azown.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.azown.entity.Address;
import com.example.azown.repository.AddressRepository;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    public Address updateAddress(Address address, Long id) {
        Optional<Address> optional = addressRepository.findById(id);
        if (optional.isPresent()) {
            Address dbAddress = optional.get();

            if (address.getStreet1() != null) dbAddress.setStreet1(address.getStreet1());
            if (address.getLandmark() != null) dbAddress.setLandmark(address.getLandmark());
            if (address.getCity() != null) dbAddress.setCity(address.getCity());
            if (address.getPincode() != null) dbAddress.setPincode(address.getPincode());

            return addressRepository.save(dbAddress);
        }
        return null;
    }

    public String deleteAddressById(Long id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent()) {
            addressRepository.deleteById(id);
            return "Address deleted successfully.";
        } else {
            return "Address record does not exist.";
        }
    }


    public String findAddressById(Long id) {
        Optional<Address> optional = addressRepository.findById(id);
        return optional.isPresent() ? "Address found." : "Address not found.";
    }
}
