package ru.job4j.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.domain.Person;
import ru.job4j.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository personRepository;

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    public Person saveOrUpdate(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> findById(int id) {
        return personRepository.findById(id);
    }

    public void delete(int id) {
        personRepository.deleteById(id);
    }

    public List<Person> findByEmployeeID(int id) {
        return personRepository.findAllByEmployeeID(id);
    }
}
