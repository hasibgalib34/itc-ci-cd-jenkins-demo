package com.itc.HelloWorldProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itc.HelloWorldProject.Exception.UserAlreadyExist;
import com.itc.HelloWorldProject.model.User;
import com.itc.HelloWorldProject.service.UserService;

@RestController
@RequestMapping("api/v1")
public class UserController {
	
	private UserService service;
	public UserController() {
		super();
	}
	@Autowired
	public UserController(UserService service) {
		super();
		this.service = service;
	}
	@PostMapping("user")
	public ResponseEntity<?> saveUsr(@RequestBody User u) throws UserAlreadyExist
	{
		try {
		User u11=service.saveUser(u);
		return new ResponseEntity<>(u11,HttpStatus.CREATED);
		}
		catch(UserAlreadyExist uae)
		{
			throw new UserAlreadyExist();
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("users")
	public ResponseEntity<?> getUsers()
	{
		List<User> users=service.getUsers();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	@GetMapping("user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id)
	{
		User u=service.getUserById(id);
		return new ResponseEntity<>(u,HttpStatus.OK);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable int id,@RequestBody User u)
	{
		User u33=service.upadteUser(id, u);
		return new ResponseEntity<>(u33,HttpStatus.OK);
	}
	@GetMapping("users/{email}")
	public ResponseEntity<?> getUsersByEmail(@PathVariable String email)
	{
		List<User> users=service.findByEmailId(email);
		return new ResponseEntity<>(users,HttpStatus.OK);
		
	}
	
	


}
