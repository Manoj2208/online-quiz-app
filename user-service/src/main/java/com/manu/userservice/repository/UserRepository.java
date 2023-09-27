package com.manu.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manu.userservice.Entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	Optional<User> findByEmail(String email);

}
