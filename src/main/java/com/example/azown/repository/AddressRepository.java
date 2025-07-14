package com.example.azown.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.azown.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
