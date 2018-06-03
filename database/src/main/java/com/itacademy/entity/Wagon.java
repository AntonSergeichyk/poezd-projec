package com.itacademy.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wagon", schema = "railway_storage")
public class Wagon extends BaseEntity<Long> {

    @Column(name = "number", nullable = false)
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    private Train train;

    @ManyToOne
    @JoinColumn(name = "type_wagon_id", nullable = false)
    private TypeWagon typeWagon;

    @OneToMany(mappedBy = "wagon")
    private List<Place> places = new ArrayList<>();

    public Wagon(Integer number, Train train, TypeWagon typeWagon) {
        this.number = number;
        this.train = train;
        this.typeWagon = typeWagon;
    }
}

