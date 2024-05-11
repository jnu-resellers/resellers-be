package com.cap.resellers.mentoring.model;

import com.cap.resellers.material.model.Material;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = Mentoring.ENTITY_PREFIX + "_TB")
@Builder()
public class Mentoring {

    public static final String ENTITY_PREFIX = "MENTORING";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_PK", nullable = false)
    private Long id;

    @Column(name = ENTITY_PREFIX + "_FIRST_ANSWER")
    private String firstAnswer;

    @Column(name = ENTITY_PREFIX + "_SECOND_ANSWER")
    private String secondAnswer;

    @Column(name = ENTITY_PREFIX + "_THIRD_ANSWER")
    private String thirdAnswer;

    public static Mentoring createMentoring(String firstAnswer, String secondAnswer, String thirdAnswer) {
        return Mentoring.builder()
                .firstAnswer(firstAnswer)
                .secondAnswer(secondAnswer)
                .thirdAnswer(thirdAnswer)
                .build();
    }

}
