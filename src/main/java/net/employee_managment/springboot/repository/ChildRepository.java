package net.employee_managment.springboot.repository;


import net.employee_managment.springboot.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Long> {
}
