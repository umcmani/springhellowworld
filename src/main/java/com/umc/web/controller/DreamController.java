package com.umc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.umc.web.service.DreamService;

@Controller
@RequestMapping("/helloWorld")
public class DreamController {

	    private DreamService dreamService;
	    
	    @Autowired
	    public void setDreamService(DreamService dreamService){
	    	this.dreamService= dreamService;
	    	
	    }
	
		@RequestMapping(value = "/hello", method = RequestMethod.GET)
		public String hello(ModelMap model) {
			model.addAttribute("msg", "Welcome to umc World!");
			return "helloWorld";
		}
		
		@RequestMapping(value = "/displayMessage/{msg}", method = RequestMethod.GET)
		public String displayMessage(@PathVariable String msg, ModelMap model) {
			model.addAttribute("msg", msg);
			return "helloWorld";
		}
		
		@RequestMapping(value = "/login/{name}/{password}", method = RequestMethod.GET)
		public String login(@PathVariable String name,@PathVariable String password,ModelMap model) {
			boolean result = dreamService.validateUser(name, password);
			model.addAttribute("msg", "Welcome to umc World!"+result);
			return "helloWorld";
		}
		
		
		@RequestMapping(value = "/prepareUser", method = RequestMethod.GET)
		public String prepareUser(ModelMap model) {
			dreamService.prepareUser();
			model.addAttribute("msg", "User DB prepared..!");
			return "helloWorld";
		}
	}
