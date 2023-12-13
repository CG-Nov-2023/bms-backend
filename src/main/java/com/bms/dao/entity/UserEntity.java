package com.bms.dao.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name="user")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	int userId;
	
	@Column(name="user_name")
	String userName;
	
	@Column(name="user_password")
	String userPassword;
	
	@ManyToMany
	@JoinTable(name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"),
				inverseJoinColumns  = @JoinColumn(name = "roles_id"))
	List<RolesEntity> allRolesEntity;
}


