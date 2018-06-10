package com.itacademy.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user\"", schema = "railway_storage")
public class User extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "mailbox")
    private String mailbox;
}
