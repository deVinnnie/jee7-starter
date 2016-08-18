package com.realdolmen.course.repository;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.PassengerId;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PassengerRepository {

    @PersistenceContext
    EntityManager em;

    public Passenger save(Passenger passenger){
        em.persist(passenger);
        return passenger;
    }

    public Passenger update(Passenger passenger){
        passenger = em.merge(passenger);
        return passenger;
    }

    public void remove(Passenger passenger){
        passenger = em.merge(passenger);
        em.remove(passenger);
    }

    public void remove(PassengerId id){
        em.remove(em.getReference(Passenger.class, id));
    }

    public Passenger refresh(Passenger passenger){
        em.refresh(passenger);
        return passenger;
    }

    public Passenger findById(PassengerId id){
        return em.find(Passenger.class, id);
    }

    public List<Passenger> findAll(){
        List<Passenger> allPassengers = em.createNamedQuery(Passenger.FIND_ALL, Passenger.class)
                .getResultList();
        return allPassengers;
    }
}
