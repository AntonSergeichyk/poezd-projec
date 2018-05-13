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
@Table(name = "wagon", schema = "railway_storage")
public class Wagon extends BaseEntity<Long> {

    @Column(name = "number", nullable = false, unique = false)
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false, unique = true)
    private Train train;

    @ManyToOne
    @JoinColumn(name = "type_wagon_id", nullable = false, unique = false)
    private TypeWagon typeWagon;

    @OneToMany(mappedBy = "wagon")
    private List<Place> places = new ArrayList<>();

    public Wagon(Integer number, Train train, TypeWagon typeWagon) {
        this.number = number;
        this.train = train;
        this.typeWagon = typeWagon;
    }
}

