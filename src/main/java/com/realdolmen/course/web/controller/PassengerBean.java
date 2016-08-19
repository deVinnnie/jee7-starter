package com.realdolmen.course.web.controller;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.PassengerId;
import com.realdolmen.course.domain.PassengerType;
import com.realdolmen.course.repository.PassengerRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Named
@SessionScoped
public class PassengerBean implements Serializable{

    private String lastName = "Potter";

    private String ssn = "123";

    private String firstName = "Harry";

    private String dateOfBirth = "";

    private PassengerType type = PassengerType.OCCASIONAL;

    @Inject
    private PassengerRepository passengerRepository;


    public String register(){
        return "confirm.xhtml";


    }

    public String confirm() {
        Passenger passenger = new Passenger(
                new PassengerId(ssn, lastName),
                firstName,
                new Date(),
                type
        );

        passengerRepository.save(passenger);

        return "index.xhtml";
    }



    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public PassengerType getType() {
        return type;
    }

    public void setType(PassengerType type) {
        this.type = type;
    }
}
