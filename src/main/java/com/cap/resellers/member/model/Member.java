package com.cap.resellers.member.model;

import com.cap.resellers.common.BaseEntity;
import com.cap.resellers.material.model.Material;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(exclude = {"materials"})
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

    @Column(name = ENTITY_PREFIX + "_BANK_NAME")
    private String bankName;

    @Column(name = ENTITY_PREFIX + "_ACCOUNT_NUMBER")
    private String accountNumber;


    @Column(name = ENTITY_PREFIX + "_CONTACT", nullable = false)
    private String contact;

    @OneToMany(mappedBy = "member")
    @JsonManagedReference
    private List<Material> materials = new ArrayList<>();
}
