package ru.job4j.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.domain.Employee;
import ru.job4j.domain.Person;
import ru.job4j.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PersonService personService;

    public List<Employee> findAll() {
        return employeeRepository.findAll().stream()
                .map(employee -> findById(employee.getId()))
                .collect(Collectors.toList());
    }

    public Employee findById(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        List<Person> allAccounts = (List<Person>) personService.findAll();
        if (employee != null) {
            employee.setAccounts(allAccounts.stream()
                    .filter(person -> person.getEmployeeID() == id)
                    .collect(Collectors.toList()));
        }
        return employee;
    }

    public Employee saveOrUpdate(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeWithAccountsById(int id) {
        var persons = personService.findByEmployeeID(id);
        persons.forEach(person -> personService.delete(person.getId()));
        employeeRepository.deleteById(id);
    }
}
