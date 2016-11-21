package com.acknotech.core.controllers.Users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.acknotech.core.dto.users.Users;
import com.acknotech.core.model.UsersVO;
import com.acknotech.core.services.UserService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserListController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/users", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<List<UsersVO>> getAllUsers() {	 
		  List<UsersVO> organization=this.userService.findAllUsers();
		  return new ResponseEntity<List<UsersVO>>(organization, HttpStatus.OK);
		}
	
	@RequestMapping(value = "/usersadd", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("user") Users user) {

	logger.info("in add user method");

	if (user.getId() == 0) {
	    // new person, add it
	    this.userService.addUser(user);
	} else {
	    // existing person, call update
	    this.userService.updateUser(user);
	}

	return "redirect:/users";

    }
	
	@RequestMapping(value = "/getUserById.do", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public UsersVO getUserById(HttpServletRequest httpServletRequest,
		    HttpServletResponse httpServletResponse) {
		System.out.println("in get user by id method..");
		
		String str = (String) httpServletRequest.getParameter("id");
		System.out.println("Value is :: " + str);
		int userId = Integer.parseInt(str);
		System.out.println("2nd Value is :: " + userId);
		if(httpServletRequest.getAttribute("id") != null)
	    	userId = (Integer) httpServletRequest.getAttribute("id");
		UsersVO userData = this.userService.getUserById(userId);
			return userData;
		
	}
	
}
