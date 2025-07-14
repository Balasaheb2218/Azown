
package com.example.azown.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.azown.entity.Address;
import com.example.azown.service.AddressService;

@RestController
@RequestMapping("/Address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressService.createAddress(address);
    }

    @GetMapping
    public List<Address> listOfAddresses() {
        return addressService.findAllAddresses();
    }

    @PutMapping
    public Address updateAddress(@RequestBody Address address, @RequestParam Long id) {
        return addressService.updateAddress(address, id);
    }

    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable Long id) {
        return addressService.deleteAddressById(id);
    }

    @GetMapping("Address/{id}")
    public String findAddressById(@PathVariable Long id) {
        return addressService.findAddressById(id);
    }
}
