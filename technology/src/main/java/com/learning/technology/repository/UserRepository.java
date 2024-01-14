package com.learning.technology.repository;

import com.learning.technology.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByAddress(String address);

}
