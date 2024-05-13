package com.example.onlineBriefing.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "universitygroup")
public class UniversityGroup {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_profile", nullable = false)
    private Integer id_profile;

    @Column(name = "year_begin", nullable = false)
    private Integer year_begin;

    @Column(name = "number", nullable = false)
    private String number;

}
