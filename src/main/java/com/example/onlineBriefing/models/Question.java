package com.example.onlineBriefing.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Question")
public class Question {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_briefing", nullable = false)
    private Integer id_briefing;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "type_verification")
    private String type_verification;

    @Column(name = "answer")
    private String answer;

    @Builder(toBuilder = true)
    public Question(Integer id, Integer id_briefing, String text, String type_verification, String answer) {
        this.id = id;
        this.id_briefing = id_briefing;
        this.text = text;
        this.type_verification = type_verification;
        if (type_verification.equals("automatically")) {
            this.answer = null;
        } else {
            this.answer = answer;
        }
    }

}
