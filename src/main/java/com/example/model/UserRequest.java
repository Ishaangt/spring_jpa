package com.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

public class UserRequest {
	
	private String username;
	private String password;
	
	@JsonAlias("roles")
	private List<ParentRoleUserModel> parent;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<ParentRoleUserModel> getParent() {
		return parent;
	}
	public void setParent(List<ParentRoleUserModel> parent) {
		this.parent = parent;
	}
}
