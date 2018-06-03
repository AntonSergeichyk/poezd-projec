package com.itacademy.service;

import com.itacademy.entity.Booking;
import com.itacademy.entity.Train;
import com.itacademy.entity.User;
import com.itacademy.entity.Wagon;
import com.itacademy.service.interfaces.BookingService;
import com.itacademy.service.interfaces.TrainService;
import com.itacademy.service.interfaces.UserService;
import com.itacademy.service.interfaces.WagonService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class BookingServiceTest extends BaseServiceTes {

    @Autowired
    private UserService userService;
    @Autowired
    private TrainService trainService;
    @Autowired
    private WagonService wagonService;
    @Autowired
    private BookingService bookingService;

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", bookingService);
    }


    @Test
    public void findAllByUserId() {
        User user = userService.findByNameAndPassword("Anton", "pass");
        List<Booking> results = bookingService.findAllByUserId(user.getId());
        assertThat(results, hasSize(1));
        assertThat(results.get(0).getUser().getName(), equalTo("Anton"));
    }

    @Test
    public void findAllByPlaceWagonId() {
        Train train = trainService.findByName("минск-брест");
        Wagon wagon = wagonService.findByNumberAndTrainId(1, train.getId());
        List<Booking> results = bookingService.findAllByPlaceWagonId(wagon.getId());
        assertThat(results, hasSize(1));
        assertThat(results.get(0).getUser().getName(), equalTo("Anton"));
    }
}
