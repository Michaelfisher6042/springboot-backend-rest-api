package net.employee_managment.springboot.service;

import java.util.List;

import net.employee_managment.springboot.model.Employee;



public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	void addEmployees(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee, long id);
	void deleteEmployee(long id);
}
