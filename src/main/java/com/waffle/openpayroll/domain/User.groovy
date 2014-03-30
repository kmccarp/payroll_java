package com.waffle.openpayroll.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table;

@Entity
@Table(name="Employee")
class User {
	
	@Id
	@GeneratedValue
	long id
	
	@Column(nullable = false)
	String username
	
	@Column(nullable = false)
	String password
}
