package com.waffle.openpayroll.domain

class Employee extends User {
	String name
	PayRate payRate
	boolean salaried
	Manager manager
}
