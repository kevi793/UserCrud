package com.sc.interview.crudapp.repository;

import com.sc.interview.crudapp.entity.Address;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, UUID> {

    List<Address> getByUser(UUID userId);
}
