package com.realdolmen.course.service;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Person;
import com.realdolmen.course.utilities.integration.RemoteIntegrationTest;
import org.junit.Test;

import java.util.List;


public class PassengerEJBRemoteTest extends RemoteIntegrationTest {
    @Test
    public void testPersonServiceCanBeAccessedRemotely() throws Exception {
        PassengerEJBRemote passengerEJB = lookup("jee7-starter/PassengerEJB!com.realdolmen.course.service.PassengerEJBRemote");
        List<Passenger> passengers = passengerEJB.findPassengers();
        assertEquals(3, passengers.size());
        logger.trace("---------------*---------------*");
        for (Passenger passenger : passengers) {
            logger.trace("Retrieved person " + passenger);
        }
        logger.trace("---------------*---------------*");
    }
}
