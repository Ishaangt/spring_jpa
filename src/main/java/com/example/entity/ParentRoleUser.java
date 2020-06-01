package com.example.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "parent_roles", schema = "public")
public class ParentRoleUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -558777578324250019L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parent_genetor")
	@SequenceGenerator(name="parent_genetor", sequenceName = "role_parent_seq", allocationSize=1)
	private int id;
	
	@Column(name = "parent_role")
	private String parentRole;
	
	@OneToMany(mappedBy = "parentRoles", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RoleUser> subroles;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParentRole() {
		return parentRole;
	}

	public void setParentRole(String parentRole) {
		this.parentRole = parentRole;
	}

	public List<RoleUser> getSubroles() {
		return subroles;
	}

	public void setSubroles(List<RoleUser> subroles) {
		this.subroles = subroles;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
