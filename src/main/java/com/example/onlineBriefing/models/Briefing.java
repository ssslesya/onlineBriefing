package com.example.onlineBriefing.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Briefing")
public class Briefing {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_subject", nullable = false)
    private Integer id_subject;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "duration", columnDefinition = "INTERVAL")
    private Duration duration;

    @Column(name = "status")
    private String status;//ENUM:   OPEN, CLOSE

    public Briefing(Integer id_subject, Integer number, String title, Duration duration, String status) {
        this.id_subject = id_subject;
        this.number = number;
        this.title = title;
        this.duration = duration;
        this.status = status;
    }
}
