package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.annotation.Nonnull;
//import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Entity
@Table(name="register")
  @Data
  @AllArgsConstructor 
  @NoArgsConstructor
public class UserRegister{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="fname")
	private String firstname;
	@Column(name="lname")
	private String lastname;
	@Column(name="email")
	private String email;
	@Column(name="pwd")
	private String 	password;
	@Column(name="mbno")
	private Long Mobileno;

	@CreationTimestamp
	@Column(name = "createdDate")
	public LocalDateTime createdDate;
	
	
	@UpdateTimestamp
	@Column(name = "updatedDate")
	public LocalDateTime updatedDate;
	
}

