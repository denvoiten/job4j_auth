package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.domain.Employee;

import java.util.Collection;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Collection<Employee> findAll();
}
