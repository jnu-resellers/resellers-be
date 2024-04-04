package com.cap.resellers.product.model;

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
@Table(name = Product.ENTITY_PREFIX + "_TB")
@Builder()
public class Product extends BaseEntity {

    public static final String ENTITY_PREFIX = "PRODUCT";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_PK", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATERIAL_FK")
    private Material material;

    @Column(name = ENTITY_PREFIX + "_NAME", nullable = false)
    private String name;

    @Column(name = ENTITY_PREFIX + "_PRICE", nullable = false)
    private Long price;

    @Column(name = ENTITY_PREFIX + "_DESCRIPTION", nullable = false)
    private String description;

    @Column(name = ENTITY_PREFIX + "_BUYER")
    private Long buyer;

    @Column(name = ENTITY_PREFIX + "_SELLER", nullable = false)
    private Long seller;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Image> images = new ArrayList<>();

    public static Product createProduct(Long seller, String name, Long price, String description, List<Image> images) {
        Product product1 = Product.builder()
                .seller(seller)
                .name(name)
                .price(price)
                .description(description)
                .images(images)
                .build();
        for (Image image : images) {
            image.mappingProduct(product1);
        }
        return product1;
    }

    public void mappingMaterial(Material material) {
        this.material = material;
    }
}
