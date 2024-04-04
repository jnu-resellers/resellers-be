package com.cap.resellers.member.model;

import com.cap.resellers.common.BaseEntity;
import com.cap.resellers.material.model.Material;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = Member.ENTITY_PREFIX + "_TB")
@Builder()
public class Member extends BaseEntity {

    public static final String ENTITY_PREFIX = "MEMBER";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_PK", nullable = false)
    private Long id;

    @Column(name = ENTITY_PREFIX + "_NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "member")
    private List<Material> materials = new ArrayList<>();
}
