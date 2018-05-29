package com.itacademy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserData {

    @Id
    private long id;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "patronymic", nullable = false)
    private String patronymic;

    @Column(name = "passport", nullable = false)
    private String passport;

    public UserData(String surname, String name, String patronymic, String passport) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.passport = passport;
    }
}
