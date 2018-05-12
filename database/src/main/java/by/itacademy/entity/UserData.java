package by.itacademy.entity;

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
public class FioUser {

    @Column(name = "surname", nullable = false, unique = false)
    private String surname;

    @Column(name = "name", nullable = false, unique = false)
    private String name;

    @Column(name = "patronymic", nullable = false, unique = false)
    private String patronymic;
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
