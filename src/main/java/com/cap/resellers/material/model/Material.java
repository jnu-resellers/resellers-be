package com.cap.resellers.material.model;

import com.cap.resellers.common.BaseEntity;
import com.cap.resellers.member.model.Member;
import com.cap.resellers.product.model.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(exclude = {"member"})
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

    @Enumerated(EnumType.STRING)
    @Column(name = ENTITY_PREFIX + "_ITEM_TYPE")
    private ItemType itemType;

    @Column(name = ENTITY_PREFIX + "_CONTACT")
    private String contact;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_FK")
    private Product product;

    public static Material createMaterial(Member member, ItemType itemType, Product product, String contact) {
        Material material = Material.builder()
                .product(product)
                .member(member)
                .itemType(itemType)
                .contact(contact)
                .build();
        return material;
    }


}
