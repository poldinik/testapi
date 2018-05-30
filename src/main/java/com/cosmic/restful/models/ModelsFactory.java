package com.cosmic.restful.models;

import java.util.UUID;

public class ModelsFactory {

	private ModelsFactory(){
	}
	
	public static User createUser() {
		return new User(UUID.randomUUID().toString());
	}
	

}
