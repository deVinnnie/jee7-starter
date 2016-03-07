package com.realdolmen.tickets.beans;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.repository.PersonRepository;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class PersonBean {
    @EJB
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}