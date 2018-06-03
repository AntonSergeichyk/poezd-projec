package com.itacademy.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "train", schema = "railway_storage")
public class Train extends BaseEntity<Long> {

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "train")
    private List<Wagon> wagons = new ArrayList<>();

    public Train(Integer number, String name) {
        this.number = number;
        this.name = name;
    }
}
