package com.itacademy.service.interfaces;

import com.itacademy.entity.Booking;

import java.util.List;

public interface BookingService extends BaseService<Long, Booking> {

    List<Booking> findAllByUserId(Long userId);

    List<Booking> findAllByPlaceWagonId(Long wagonId);
}
