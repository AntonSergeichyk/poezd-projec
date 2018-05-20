package by.itacademy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity<PK extends Serializable> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private PK id;
}
