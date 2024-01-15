package com.itc.HelloWorldProject.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT,   reason="With this id user is present")
public class UserAlreadyExist extends Exception{

}
