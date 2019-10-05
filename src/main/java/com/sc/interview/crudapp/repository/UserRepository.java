package com.sc.interview.crudapp.repository;

import com.sc.interview.crudapp.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT DISTINCT user FROM User as user "
            + "left join fetch user.addressList as addressList ")
    public List<User> findUsersWithAddresses();

    @Query("SELECT DISTINCT user FROM User as user "
            + "left join fetch user.addressList as addressList "
            + "where user.id = :id")
    public User findUserWithAddresses(int id);
}
