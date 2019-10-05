package com.sc.interview.crudapp.repository;

import com.sc.interview.crudapp.entity.User;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("SELECT DISTINCT user FROM User as user "
            + "left join fetch user.addressList as address ")
    public List<User> findUsersWithAddresses();

    @Query("SELECT DISTINCT user FROM User as user "
            + "left join fetch user.addressList as address "
            + "where user.id = :uuid")
    public User findUserWithAddresses(UUID uuid);
}
