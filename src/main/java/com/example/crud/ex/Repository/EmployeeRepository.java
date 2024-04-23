package com.example.crud.ex.Repository;

import com.example.crud.ex.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.name = :name")
    List<Employee> findByName(String name);

    @Query("SELECT e FROM Employee e WHERE e.place = :place")
    List<Employee> findByPlace(String place);

    @Query("SELECT e FROM Employee e WHERE e.name IN :names")
    List<Employee> findByNameIn(List<String> names);

    @Query("SELECT e FROM Employee e WHERE e.place IN :places")
    List<Employee> findByPlaceIn(List<String> places);
}
