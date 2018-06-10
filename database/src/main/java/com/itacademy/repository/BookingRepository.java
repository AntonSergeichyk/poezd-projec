package com.itacademy.repository;

import com.itacademy.entity.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

    List<Booking> findAllByUserId(Long userId);

    List<Booking> findAllByPlaceWagonId(Long wagonId);
}
