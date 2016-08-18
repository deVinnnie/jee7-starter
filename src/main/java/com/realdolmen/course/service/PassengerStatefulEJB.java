package com.realdolmen.course.service;

import com.realdolmen.course.domain.Address;
import com.realdolmen.course.domain.CreditCard;
import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;
import com.realdolmen.course.repository.PassengerRepository;
import com.realdolmen.course.repository.TicketRepository;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class PassengerStatefulEJB implements  PassengerStatefulEJBRemote{

    @Inject
    private PassengerRepository passengerRepository;

    @Inject
    private TicketRepository ticketRepository;

    private Passenger passenger;
    private List<Ticket> tickets = new ArrayList<>();
    private List<CreditCard> creditCardList = new ArrayList<>();

    public void createPassenger(Passenger passenger){
        this.passenger = passenger;
    }

    public void addAddress(Address address){
        this.passenger.setAddress(address);
    }

    public void addCreditCard(CreditCard creditCard){
        this.creditCardList.add(creditCard);
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
        ticket.setPassenger(passenger);
    }

    @Remove
    public void checkOut(){
        if(passenger == null){
            throw new IllegalArgumentException("");
        }

        passenger.setCards(creditCardList);
        passenger.setTickets(tickets);

        passengerRepository.save(passenger);

        for(Ticket ticket : tickets) {
            ticketRepository.save(ticket);
        }
    }
}
