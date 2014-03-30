package com.waffle.openpayroll.domain

class Employee extends User {
	String name
	double payRate
	boolean salaried
	Manager manager
}
