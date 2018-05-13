package by.itacademy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

    @Column(name = "number", nullable = false, unique = true)
    private Integer number;

    @Column(name = "name", nullable = false, unique = false)
    private String name;

    @OneToMany(mappedBy = "train")
    private List<Wagon> wagons = new ArrayList<>();

    public Train(Integer number, String name) {
        this.number = number;
        this.name = name;
    }
}
