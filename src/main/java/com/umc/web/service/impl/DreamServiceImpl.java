package com.umc.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umc.web.dao.DreamDAO;
import com.umc.web.service.DreamService;

@Service
public class DreamServiceImpl  implements DreamService{

	
	private DreamDAO dreamDAO;
	
	@Autowired	
	public void setDreamDAO(DreamDAO dreamDAO){
		this.dreamDAO  = dreamDAO;
	}
	
		
		public boolean validateUser(String name, String password){
			return dreamDAO.validateUser( name, password);
		   
		}
		
		public void prepareUser(){
			dreamDAO.prepareUser();
		}
		
	}
