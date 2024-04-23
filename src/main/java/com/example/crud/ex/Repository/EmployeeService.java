package com.example.crud.ex.Repository;

import com.example.crud.ex.model.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    @Query("SELECT e FROM Employee e WHERE e.id = :id")
    Optional<Employee> getEmployeeById(@Param("id") int id);

    @Query("SELECT e FROM Employee e WHERE e.name = :name")
    List<Employee> getEmployeesByName(@Param("name") String name);

    @Query("SELECT e FROM Employee e WHERE e.place = :place")
    List<Employee> getEmployeesByPlace(@Param("place") String place);

    @Query("SELECT e FROM Employee e WHERE e.name IN :names")
    List<Employee> getEmployeesByNames(@Param("names") List<String> names);

    @Query("SELECT e FROM Employee e WHERE e.place IN :places")
    List<Employee> getEmployeesByPlaces(@Param("places") List<String> places);

    @Modifying
    @Query("UPDATE Employee e SET e.name = :#{#employee.name}, e.place = :#{#employee.place} WHERE e.id = :#{#employee.id}")
    Employee updateEmployee(@Param("employee") Employee employee);

    @Modifying
    @Query("DELETE FROM Employee e WHERE e.id = :id")
    void deleteEmployee(@Param("id") int id);

    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM Employee e WHERE e.id = :id")
    boolean existsById(@Param("id") int id);


}
