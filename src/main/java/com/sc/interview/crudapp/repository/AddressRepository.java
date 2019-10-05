package com.sc.interview.crudapp.repository;

import com.sc.interview.crudapp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
