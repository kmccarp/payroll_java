package com.openpayroll.dao;

import com.openpayroll.domain.Employee;
import com.openpayroll.domain.Manager;
import com.openpayroll.domain.Role;
import com.openpayroll.domain.User;

public interface UserSaveDAO {

	void saveUser(User user);
	
	void saveEmployee(Employee employee);
	
	void saveManager(Manager manager);
	
	void setUserRole(User user, Role role);
	
	void removeUserRole(User user, Role role);
}
