package com.realdolmen.course.service;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.PassengerId;
import com.realdolmen.course.repository.PassengerRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class PassengerEJB implements PassengerEJBRemote{

    @Inject
    private PassengerRepository passengerRepository;


    public List<Passenger> findPassengers(){
        return passengerRepository.findAll();
    }

    public Passenger findPassengerById(PassengerId id){
        return passengerRepository.findById(id);
    }

    public void createPassenger(Passenger passenger){
        passengerRepository.save(passenger);
    }

    public void deletePassenger(Passenger passenger){
        passengerRepository.remove(passenger);
    }

    public void updatePassenger(Passenger passenger){
        passengerRepository.update(passenger);
    }
}
