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
@Table(name = "role", schema = "railway_storage")
public class Role extends BaseEntity<Integer> {

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}
