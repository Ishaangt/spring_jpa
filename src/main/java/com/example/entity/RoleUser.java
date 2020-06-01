package com.example.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "sub_roles", schema = "public")
public class RoleUser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4279723651883347677L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sub_role_generator")
	@SequenceGenerator(name="sub_role_generator", sequenceName = "role_sub_seq", allocationSize=1)
	private int id;
	
	@Column(name = "role")
	private String role;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_role_id")
	private ParentRoleUser parentRoles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ParentRoleUser getParentRoles() {
		return parentRoles;
	}

	public void setParentRoles(ParentRoleUser parentRoles) {
		this.parentRoles = parentRoles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
