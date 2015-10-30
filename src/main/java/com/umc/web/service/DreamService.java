package com.umc.web.service;

import org.springframework.stereotype.Service;

@Service
public interface DreamService {

	
		public boolean validateUser(String name, String password);
		
		public void prepareUser();
		
	}
