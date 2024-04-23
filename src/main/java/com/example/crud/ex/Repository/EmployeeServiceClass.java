package com.example.crud.ex.Repository;

import com.example.crud.ex.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceClass implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceClass(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeesByPlace(String place) {
        return employeeRepository.findByPlace(place);
    }

    @Override
    public List<Employee> getEmployeesByNames(List<String> names) {
        return employeeRepository.findByNameIn(names);
    }

    @Override
    public List<Employee> getEmployeesByPlaces(List<String> places) {
        return employeeRepository.findByPlaceIn(places);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return employeeRepository.existsById(id);
    }

}
