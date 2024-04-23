package com.example.crud.ex.Repository;

import com.example.crud.ex.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(int id);

    List<Employee> getEmployeesByName(String name);

    List<Employee> getEmployeesByPlace(String place);

    List<Employee> getEmployeesByNames(List<String> names);

    List<Employee> getEmployeesByPlaces(List<String> places);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(int id);

    boolean existsById(int id);

}
