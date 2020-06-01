package com.example.model;

import java.util.List;

public class ParentRoleUserModel {

	private String parent_role;
	private List<SubRoleUserModel> sub_roles;
	
	public String getParent_role() {
		return parent_role;
	}
	public void setParent_role(String parent_role) {
		this.parent_role = parent_role;
	}
	public List<SubRoleUserModel> getSub_roles() {
		return sub_roles;
	}
	public void setSub_roles(List<SubRoleUserModel> sub_roles) {
		this.sub_roles = sub_roles;
	}
	
	
}
