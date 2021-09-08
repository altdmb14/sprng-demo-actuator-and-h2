package com.example.demo2021.dao;

import com.example.demo2021.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PersonDAO extends CrudRepository<Person, Long> {
    public List<Person> findByFullNameLike(String name);
    public List<Person> findByDateOfBirthGreaterThan(Date date);
}
