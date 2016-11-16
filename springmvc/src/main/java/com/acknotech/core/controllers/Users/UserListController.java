package com.acknotech.core.controllers.Users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;

@RestController
public class UserListController {
	
	@RequestMapping(value = "/users", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<List<UsersVO>> getAllUsers() {	 
		  List<UsersVO> organization=this.userService.findAllOrganizations();
		  return new ResponseEntity<List<UsersVO>>(organization, HttpStatus.OK);
		}
	
}
