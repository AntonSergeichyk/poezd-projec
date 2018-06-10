package com.itacademy.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "time_table", schema = "railway_storage")
public class TimeTable extends BaseEntity<Long> {

    @OneToOne
    @JoinColumn(name = "station_start_id", nullable = false)
    private Station stationStart;

    @OneToOne
    @JoinColumn(name = "station_finish_id", nullable = false)
    private Station stationFinish;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    @Column(name = "time_start", nullable = false)
    private LocalDateTime timeStart;

    @Column(name = "time_finish", nullable = false)
    private LocalDateTime timeFinish;
}
