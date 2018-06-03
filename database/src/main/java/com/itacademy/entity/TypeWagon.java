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
@Table(name = "type_wagon", schema = "railway_storage")
public class TypeWagon extends BaseEntity<Integer> {

    @Column(name = "type", nullable = false)
    private String type;
}
