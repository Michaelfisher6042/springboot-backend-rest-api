package net.employee_managment.springboot.repository;


import net.employee_managment.springboot.model.Spouse;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface SpouseRepository extends JpaRepository<Spouse, Long> {
}

