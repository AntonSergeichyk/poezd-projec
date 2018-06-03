package com.itacademy.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking", schema = "railway_storage")
public class Booking extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Embedded
    private UserData userData;

    @OneToOne
    @JoinColumn(name = "place_id")
    private Place place;
}
