package com.itacademy.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "type_place", schema = "railway_storage")
public class TypePlace extends BaseEntity<Integer> {

    @Column(name = "type", nullable = false, unique = true)
    private String type;
}
