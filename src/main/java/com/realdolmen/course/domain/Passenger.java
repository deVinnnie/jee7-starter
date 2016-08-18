package com.realdolmen.course.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = Passenger.FIND_ALL, query = "SELECT p FROM Passenger p"),
        @NamedQuery(name = Passenger.FIND_ALL_LAST_NAMES, query = "SELECT p.id.lastName FROM Passenger p"),
        @NamedQuery(name = Passenger.TOTAL_FREQUENT_FLYER_MILES, query = "SELECT SUM(p.frequentFlyerMiles) FROM Passenger p"),
        @NamedQuery(name = Passenger.FIND_TICKETS_BY_PASSENGER_ID, query = "SELECT p.tickets FROM Passenger p WHERE p.id = :id"),
        @NamedQuery(name = Passenger.DELETE_ALL, query = "DELETE FROM Passenger p WHERE p.tickets IS EMPTY")
})
public class Passenger {
    public static final String FIND_ALL = "Passenger.findAll";
    public static final String FIND_ALL_LAST_NAMES = "Passenger.findAllLastNames";
    public static final String TOTAL_FREQUENT_FLYER_MILES = "Passenger.totalFrequentFlyerMiles";
    public static final String FIND_TICKETS_BY_PASSENGER_ID = "Passenger.findTicketsByPassengerId";
    public static final String DELETE_ALL = "Passenger.deleteAll";


    @EmbeddedId
    private PassengerId id;

    @Size(max = 50)
    private String firstName;

    @Min(0)
    private Integer frequentFlyerMiles = 0;

    @NotNull
    @Past
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth = new Date();

    @NotNull
    @Enumerated(EnumType.STRING)
    private PassengerType type;

    @Past
    @Temporal(TemporalType.DATE)
    private Date lastFlight;

    @Embedded
    private Address address;

    @ElementCollection
    private List<CreditCard> cards;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] picture;

    @ElementCollection
    private List<String> preferences;

    @Transient
    private int age;

    @OneToMany(mappedBy = "passenger")
    private List<Ticket> tickets;


    public Passenger() {
    }

    public Passenger(PassengerId id, String firstName, Date dateOfBirth, PassengerType type) {
        this.id = id;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.type = type;
    }

    public PassengerId getId() {
        return id;
    }

    public void setId(PassengerId id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(Integer frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public PassengerType getType() {
        return type;
    }

    public void setType(PassengerType type) {
        this.type = type;
    }

    public Date getLastFlight() {
        return lastFlight;
    }

    public void setLastFlight(Date lastFlight) {
        this.lastFlight = lastFlight;
    }

    public List<CreditCard> getCards() {
        return cards;
    }

    public void setCards(List<CreditCard> cards) {
        this.cards = cards;
    }

    public int getAge() {
        Date currentDate = new Date();
        Long age = currentDate.getTime() - dateOfBirth.getTime();
        Date dt = new Date(age);

        return dt.getYear();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }
}
