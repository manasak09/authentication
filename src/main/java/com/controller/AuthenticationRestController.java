package com.controller;

import java.util.List;

import javax.naming.AuthenticationException;
import javax.validation.constraints.NotNull;

import org.hibernate.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.AuthenticationService;
import com.model.Authentication;


@RestController
public class AuthenticationRestController {
	@Autowired
	AuthenticationService loginScreenService;
	@GetMapping("/users")
	public List<Authentication> getAllUsers(){
		return loginScreenService.findAllUsers();
	}
	@PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Authentication loginScreen){
		boolean result= loginScreenService.checkLogin(loginScreen.getUserName(),loginScreen.getPassWord() );
		
		if(result) {
	
			return ResponseEntity.status(HttpStatus.OK).body("login succesfull");
		}
		return ResponseEntity.status(HttpStatus.OK).body("login failed");
	}
	@PostMapping("/adduser")
	 public ResponseEntity<?> addUser(@RequestBody Authentication loginScreen){
	  loginScreenService.addLogin(loginScreen);
	 return ResponseEntity.status(HttpStatus.OK).body("user added");
	}
		
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id) throws DeleteAutenticationException{
		Authentication authentication=loginScreenService.findLogin(id);
		if(loginScreenService==null) {
			throw new DeleteAutenticationException(id);
		}
		loginScreenService.deleteLogin(id);
		return ResponseEntity.ok("User deleted ");	
	}
	 @GetMapping("/finduser/{id}")
	 public ResponseEntity<?> findUser(@PathVariable int id){
			Authentication authentication=loginScreenService.findLogin(id);
//			if(loginScreenService==null) {
//				
//			}
//			loginScreenService.findLogin(id);
			return ResponseEntity.ok("User finded ");	
		 
	 }
	}


