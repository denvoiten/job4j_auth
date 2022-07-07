package ru.job4j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.domain.Employee;
import ru.job4j.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> findAll() {
        return this.employeeService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> findById(@PathVariable int id) {
        var employee = this.employeeService.findById(id);
        return new ResponseEntity<>(
                employee != null ? employee : new Employee(),
                employee != null ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @PostMapping("/")
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        return new ResponseEntity<>(
                this.employeeService.saveOrUpdate(employee),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        this.employeeService.deleteEmployeeWithAccountsById(id);
        return ResponseEntity.ok().build();
    }
}
