package com.fieb.tcc.academicologin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.fieb.tcc.academicologin.service.UserService;
import com.fieb.tcc.academicologin.web.dto.UserDto;

@Controller
public class UserController {

	
	private UserService userService;
	
	public UserController(UserService userService){
	
		this.userService = userService;
	}

	@GetMapping("/registration")
	public String showRegistrationForm() {
		return "registration";
	}
	
	public String registerUserAccount(@ModelAttribute("user") UserDto userDto) {
		userService.save(userDto);
		return "redirect:/registration?success";
	}
}
