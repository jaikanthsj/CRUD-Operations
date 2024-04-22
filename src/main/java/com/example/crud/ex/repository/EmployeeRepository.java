package com.example.crud.ex.repository;

import com.example.crud.ex.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
