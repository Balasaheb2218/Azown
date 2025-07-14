package com.example.azown.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.azown.entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long>{

}
