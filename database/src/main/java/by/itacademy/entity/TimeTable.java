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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "time_table", schema = "railway_storage")
public class TimeTable extends BaseEntity<Long> {


    @OneToOne
    @JoinColumn(name = "station_start_id", nullable = false, unique = false)
    private Station stationStart;

    @OneToOne
    @JoinColumn(name = "station_finish_id", nullable = false, unique = false)
    private Station stationFinish;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    @Column(name = "time_start", nullable = false, unique = false)
    private LocalDate timeStart;

    @Column(name = "time_finish", nullable = false, unique = false)
    private LocalDate timeFinish;
}
