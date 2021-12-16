package net.employee_managment.springboot.repository;

import net.employee_managment.springboot.model.GeneralDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface GeneralDetailsRepository extends JpaRepository<GeneralDetails, Long>{
}
