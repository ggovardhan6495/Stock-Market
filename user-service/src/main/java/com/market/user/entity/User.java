package com.market.user.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "TBL_USERS",
	uniqueConstraints = {
		@UniqueConstraint(columnNames="USERNAME"),
		@UniqueConstraint(columnNames="EMAIL")
	})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	@Column(name="USERNAME")
	private String username;
	@Column(name="EMAIL")
	private String email;
	@Column(name="PASSWORD")
	private String password;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "TBL_USER_ROLES", 
			joinColumns = { 
					@JoinColumn(name = "USER_ID") }, 
			inverseJoinColumns = {
					@JoinColumn(name = "ROLE_ID") })
	private Set<Role> role;

	public User(String username, String email, String encryptedPassword) {
		this.username=username;
		this.email=email;
		this.password=encryptedPassword;
	}	
}
