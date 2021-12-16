package net.employee_managment.springboot.repository;


import net.employee_managment.springboot.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface AddressRepository extends JpaRepository<Address, Long> {
}