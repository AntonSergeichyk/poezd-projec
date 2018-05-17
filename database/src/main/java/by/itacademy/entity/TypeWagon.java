package by.itacademy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

    @Column(name = "type", nullable = false, unique = true)
    private String type;
}
