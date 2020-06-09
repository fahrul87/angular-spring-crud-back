package com.fahrul.springAngular.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fahrul.springAngular.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
List<User> findByEmail(String email);
}
