package com.waffle.openpayroll.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Employee")
class User {
	
	@Id
	@GeneratedValue
	long id
	
	@UniqueConstraint(columnNames="username")
	@Column(nullable = false)
	String username
	
	@Column(nullable = false)
	String password
}
