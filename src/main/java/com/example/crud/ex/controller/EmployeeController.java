package com.example.crud.ex.controller;

import com.example.crud.ex.model.Employee;
import com.example.crud.ex.Repository.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/byName")
    public ResponseEntity<List<Employee>> getEmployeesByNames(@RequestParam List<String> names) {
        List<Employee> employees = employeeService.getEmployeesByNames(names);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/byPlace")
    public ResponseEntity<List<Employee>> getEmployeesByPlaces(@RequestParam List<String> places) {
        List<Employee> employees = employeeService.getEmployeesByPlaces(places);
        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.ok(createdEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employee.setId(id);
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
