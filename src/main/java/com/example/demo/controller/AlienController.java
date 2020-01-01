package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

public class AlienController 
{
	
	@Autowired
	AlienRepo repo ;
	
	@RequestMapping("/")
	public String home()
	{
		System.out.println("inside home");
	    return "home.jsp";
	}
	
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien)
	
	{
		repo.save(alien);
		return "home.jsp";	
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid)
	{
		
		ModelAndView viewName=new ModelAndView("showAlien.jsp");
		Alien alien=repo.findById(aid).orElse(new Alien());
		viewName.addObject(alien);
		return viewName;
		
	}
	
}
