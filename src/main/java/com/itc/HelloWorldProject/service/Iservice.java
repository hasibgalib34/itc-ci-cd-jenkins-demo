package com.itc.HelloWorldProject.service;

import java.util.List;

import com.itc.HelloWorldProject.Exception.UserAlreadyExist;
import com.itc.HelloWorldProject.model.User;

public interface Iservice {
public User saveUser(User u) throws UserAlreadyExist;
public List<User> getUsers();
public User getUserById(int id);
public User upadteUser(int id,User u);
public List<User> findByEmailId(String email);
}
