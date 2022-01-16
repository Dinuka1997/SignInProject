package com.example.EmployeeSys.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeSys.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	void deleteEmployeeById(int id);

	Optional<Employee> findEmployeeById(int id);

}
