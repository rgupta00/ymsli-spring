package com.bookapp.web.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookapp.model.persistance.User;
import com.bookapp.model.persistance.UserNotFoundException;
import com.bookapp.model.service.UserService;

@Controller
public class UserMgtController {

	@Autowired
	private UserService userService;

	// @PostConstruct
	public void init() {
		userService.addUser(new User("raj", "raj@raj.com", "raj123", "admin",
				true));
		userService.addUser(new User("ekta", "ekta@raj.com", "ekta123", "mgr",
				true));
		userService.addUser(new User("gunika", "gunika@raj.com", "gunika123",
				"emp", true));
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "redirect:login";
	}

	@RequestMapping(value = "login")
	public String loginGet(HttpServletRequest req, ModelMap map) {
		map.addAttribute("userbean", new UserFormBean());
		map.addAttribute("error", req.getParameter("error"));
		return "login";
	}
	
	

	@RequestMapping(value = "logout")
	public String logout(ModelMap map) {
		map.addAttribute("userbean", new UserFormBean());
		map.addAttribute("message", "you are successfully logged out!");
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loginPost(HttpServletRequest req,
			@Valid @ModelAttribute(value = "userbean") UserFormBean userbean,
			BindingResult bindingResult) {

		User user = null;
		if (bindingResult.hasErrors()) {
			return "login";
		} else {
			try {
				user = userService.getUser(userbean.getEmail(),
						userbean.getPassword());
			} catch (UserNotFoundException e) {
				return "redirect:login?error=login failed";
			}
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("user", user);
		}
		return "redirect:allbooks";

	}

}
