package com.sc.interview.crudapp.repository;

import com.sc.interview.crudapp.entity.Address;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> getByUser(int userId);
}
