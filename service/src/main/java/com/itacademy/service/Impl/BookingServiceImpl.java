package com.itacademy.service.Impl;

import com.itacademy.entity.Booking;
import com.itacademy.repository.BookingRepository;
import com.itacademy.service.interfaces.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> findAllByUserId(Long userId) {
        return bookingRepository.findAllByUserId(userId);
    }

    @Override
    public List<Booking> findAllByPlaceWagonId(Long wagonId) {
        return bookingRepository.findAllByPlaceWagonId(wagonId);
    }

    @Override
    public Booking save(Booking object) {
        return bookingRepository.save(object);
    }

    @Override
    public List<Booking> findAll() {
        Iterable<Booking> result = bookingRepository.findAll();
        ArrayList<Booking> bookings = new ArrayList<>();
        result.forEach(bookings::add);
        return bookings;
    }

    @Override
    public Booking find(Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        return booking.orElse(null);
    }

    @Override
    public void update(Booking object) {

    }

    @Override
    public void delete(Booking object) {
        bookingRepository.delete(object);
    }
}
