package com.cap.resellers.product.model;

import com.cap.resellers.common.BaseEntity;
import com.cap.resellers.material.model.Material;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@ToString(exclude = {"images"})
@Table(name = Product.ENTITY_PREFIX + "_TB")
@Builder()
public class Product extends BaseEntity {

    public static final String ENTITY_PREFIX = "PRODUCT";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_PK", nullable = false)
    private Long id;

    @Column(name = ENTITY_PREFIX + "_NAME", nullable = false)
    private String name;

    @Column(name = ENTITY_PREFIX + "_PRICE", nullable = false)
    private Integer price;

    @Column(name = ENTITY_PREFIX + "_DESCRIPTION", nullable = false)
    private String description;

    @Column(name = ENTITY_PREFIX + "_DEFECT", nullable = false)
    private String defect;

    @Column(name = ENTITY_PREFIX + "_SELLER", nullable = false)
    private Long seller;

    @Column(name = ENTITY_PREFIX + "_IS_SOLD", nullable = false)
    @Builder.Default
    private Boolean isSold = false;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Image> images = new ArrayList<>();

    public static Product createProduct(Long seller, String name, Integer price, String description, List<Image> images, String defect) {
        Product product1 = Product.builder()
                .seller(seller)
                .name(name)
                .price(price)
                .defect(defect)
                .description(description)
                .images(images)
                .build();
        for (Image image : images) {
            image.mappingProduct(product1);
        }
        return product1;
    }

    public void sold() {
        this.isSold = true;
    }
}
