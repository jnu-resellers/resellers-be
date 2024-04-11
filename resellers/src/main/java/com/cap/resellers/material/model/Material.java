package com.cap.resellers.material.model;

import com.cap.resellers.common.BaseEntity;
import com.cap.resellers.member.model.Member;
import com.cap.resellers.product.model.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(exclude = {"member", "products"})
@Entity
@Table(name = Material.ENTITY_PREFIX + "_TB")
@Builder()
public class Material extends BaseEntity{

    public static final String ENTITY_PREFIX = "MATERIAL";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_PK", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_FK")
    @JsonBackReference
    private Member member;

    @Column(name = ENTITY_PREFIX + "_TITLE")
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = ENTITY_PREFIX + "_JOB_TYPE")
    private ItemType itemType;

    @OneToMany(mappedBy = "material", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Product> products = new ArrayList<>();

    public static Material createMaterial(Member member, String title, ItemType itemType, List<Product> products) {
        Material material = Material.builder()
                .products(products)
                .member(member)
                .title(title)
                .itemType(itemType)
                .build();
        for (Product product : products) {
            product.mappingMaterial(material);
        }
        return material;
    }


}
