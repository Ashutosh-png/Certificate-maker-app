package com.workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.workshop.entity.User;
import com.workshop.service.UserServiceImpl;


@org.springframework.stereotype.Controller

@RequestMapping("/home")
public class Controller {
	@Autowired
	private UserServiceImpl service;
	
	
	public Controller (UserServiceImpl service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public String showHome() {
		return "home";
	}


	@GetMapping("/form")
	public String showform(Model model) {
		model.addAttribute("user", new User());
		return "form";
	}
	
	@PostMapping("/form/post")
	public String saveform(@ModelAttribute User user) {
		service.save(user);
		
		return "redirect:/home/showCert";
		
	}
	
	@GetMapping("/showCert")
	public String showCert(Model model) {
		Iterable<User> user =  service.showAll();
		model.addAttribute("user",user);
		
		
		return "cert";
	}
	
	@RequestMapping("/deleteCert")
	public String deleteCert() {
		service.deleteall();
		return "redirect:/home/form";
		
	}
	
}
