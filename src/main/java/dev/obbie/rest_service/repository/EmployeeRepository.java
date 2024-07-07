package dev.obbie.rest_service.repository;

import dev.obbie.rest_service.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
