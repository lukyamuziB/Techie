package com.user_frontend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.user_frontend.domain.User;
import com.user_frontend.service.UserService;


@Controller
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}
	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signing(@ModelAttribute("user") User user, Model model) {
		if (userService.checkUserExists(user.getUsername(), user.getEmail())){
			if (userService.checkUsernameExists(user.getEmail())){
				model.addAttribute("email Exists",true);
			}
			
			if (userService.checkEmailExists(user.getUsername())){
				model.addAttribute("user exists",true);
			}
			
			return "signup";
		}
		else {
			userService.save(user);
			return "redirect:/";
		}
		
	}
	
}
