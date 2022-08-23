package com.advancia.clientj.payload.response;

import java.util.List;

import com.advancia.clientj.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponse {
	private List<User> user;
	
	@JsonProperty("user")
	public List<User> getUsers() {
		return user;
	}

	public void setUsers(List<User> users) {
		this.user = users;
	}
}
