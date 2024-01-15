package com.itc.HelloWorldProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.HelloWorldProject.Exception.UserAlreadyExist;
import com.itc.HelloWorldProject.model.User;
import com.itc.HelloWorldProject.repository.UserInterface;
@Service
public class UserService implements Iservice {
	@Autowired
    private UserInterface repo;
	public UserService() {
		super();
	}
	@Override
	public User saveUser(User u) throws UserAlreadyExist {
		// TODO Auto-generated method stub
		if(!repo.findById(u.getId()).isEmpty())
		{
			throw new UserAlreadyExist();
		}
		User u1=repo.save(u);
		return u1;
	}
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		User u=repo.findById(id).get();
		return u;
	}
	@Override
	public User upadteUser(int id, User u) {
		// TODO Auto-generated method stub
		Optional<User> existingUser=repo.findById(id);
		User u1=existingUser.get();
		u1.setEmail(u.getEmail());
		u1.setPassword(u.getPassword());
		User u12=repo.save(u1);
		return u12;
	}
	@Override
	public List<User> findByEmailId(String email) {
		// TODO Auto-generated method stub
		List<User> usersByEmail=repo.findByEmail(email);
		return usersByEmail;
	}

}
