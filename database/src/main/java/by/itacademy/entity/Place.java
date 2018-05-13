package by.itacademy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "place", schema = "railway_storage")
public class Place extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "wagon_id", nullable = false, unique = false)
    private Wagon wagon;

    @Column(name = "number", nullable = false, unique = false)
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "type_place_id", nullable = true, unique = false)
    private TypePlace typePlace;

    @Column(name = "reserved", nullable = true, unique = false)
    private Boolean reserved;

    @Column(name = "cost", nullable = false, unique = false)
    private Double cost;
}
