package com.realdolmen.course.web.controller;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.repository.PassengerRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class AllPassengerBean {

    private List<Passenger> passengers;

    @Inject
    private PassengerRepository passengerRepository;

    @PostConstruct
    public void setUp(){
        this.passengers = passengerRepository.findAll();
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
