package com.umc.web.dao;

import org.springframework.stereotype.Service;

@Service
public interface DreamDAO {

		
		public boolean validateUser(String name, String password);
		
		public void prepareUser();
		
	}
