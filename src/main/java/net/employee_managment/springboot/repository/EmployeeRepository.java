package net.employee_managment.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.employee_managment.springboot.model.Employee;

import javax.transaction.Transactional;

@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
