package net.javaguides.ems.repository;

import net.javaguides.ems.entitiy.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// EmployeeRepository Class created and extended wit JPA repository
// which is used for Api crud operations mapping and all
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
