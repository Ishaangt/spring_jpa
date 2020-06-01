package com.example.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "public")
public class UserEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2571446652723626273L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
	@SequenceGenerator(name = "user_generator", sequenceName = "user_seq", allocationSize = 1)
	private int id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = "p_id")
	private List<ParentRoleUser> parent;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public List<ParentRoleUser> getParent() {
		return parent;
	}

	public void setParent(List<ParentRoleUser> parent) {
		this.parent = parent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
