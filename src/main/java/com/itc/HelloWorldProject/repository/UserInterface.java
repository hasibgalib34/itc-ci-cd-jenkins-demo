package com.itc.HelloWorldProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.itc.HelloWorldProject.model.User;
@Repository
public interface UserInterface extends JpaRepository<User,Integer> {
public List<User> findByEmail(String email);
public List<User> findByEmailAndPassword(String email,String password);
} 
