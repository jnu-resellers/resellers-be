package com.cap.resellers.product.model;

import com.cap.resellers.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(exclude = {"product"})
@Entity
@Table(name = Image.ENTITY_PREFIX + "_TB")
@Builder()
public class Image extends BaseEntity {

    public static final String ENTITY_PREFIX = "IMAGE";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_PK", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_FK")
    @JsonBackReference
    private Product product;

    public static Image createImage() {
        return Image.builder()
                .build();
    }

    public void mappingProduct(Product product) {
        this.product = product;
    }

}
