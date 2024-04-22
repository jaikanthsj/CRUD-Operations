package com.example.crud.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getEmployees(){
        String sql = "SELECT * FROM employees";
        List<Map<String, Object>> employees = jdbcTemplate.queryForList(sql);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Map<String, Object>>> getEmployeeByColumn(
            @RequestParam String columnName,
            @RequestParam String columnValue) {

        String sql = "SELECT * FROM employees WHERE " + columnName + " = ?";
        List<Map<String, Object>> employees = jdbcTemplate.queryForList(sql, columnValue);
        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody Map<String, Object> employee){
        String sql = "INSERT INTO employees (id, name, place) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,employee.get("id"), employee.get("name"), employee.get("place"));
        return ResponseEntity.ok("Employee created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployeeByColumn(
            @PathVariable Integer id,
            @RequestParam String columnName,
            @RequestParam String columnValue) {

        String sql = "UPDATE employees SET " + columnName + " = ? WHERE id = ?";
        jdbcTemplate.update(sql, columnValue, id);
        return ResponseEntity.ok("Employee updated successfully");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteEmployeeByColumn(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String columnName,
            @RequestParam(required = false) String columnValue) {

        String sql = "";
        if (id != null) {
            sql = "DELETE FROM employees WHERE id = ?";
            jdbcTemplate.update(sql, id);
        } else if (columnName != null && columnValue != null) {
            sql = "DELETE FROM employees WHERE " + columnName + " = ?";
            jdbcTemplate.update(sql, columnValue);
        } else {
            return ResponseEntity.badRequest().body("Either 'id' or 'columnName' and 'columnValue' must be provided.");
        }

        return ResponseEntity.ok("Employee deleted successfully");
    }

}

