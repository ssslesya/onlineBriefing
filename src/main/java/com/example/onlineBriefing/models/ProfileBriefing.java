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
@Table(name = "profilebriefing")
public class ProfileBriefing {

    @Id //??? вроде нужно просто иначе ошибка что каждая ентити должна иметь свой ид
    @Column(name = "id_profile", nullable = false)
    private Integer id_profile;

    @Column(name = "id_briefing", nullable = false)
    private Integer id_briefing;

}
