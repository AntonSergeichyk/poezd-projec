package com.itacademy.dao.interfaces;

import com.itacademy.entity.Booking;

import java.util.List;

public interface BookingDao extends Dao<Long, Booking> {

    List<Booking> findByUserId(Long userId);

    List<Booking> findByWagonId(Long trainId);
}
