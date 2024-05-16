package com.cap.resellers.trade.model;

import com.cap.resellers.common.BaseEntity;
import com.cap.resellers.member.model.Member;
import com.cap.resellers.product.model.Image;
import com.cap.resellers.product.model.Product;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = Trade.ENTITY_PREFIX + "_TB")
@Builder()
public class Trade extends BaseEntity {
    public static final String ENTITY_PREFIX = "TRADE";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_PK", nullable = false)
    private Long id;

    @Column(name = ENTITY_PREFIX + "_CONFIRM", nullable = false)
    private Boolean confirm;

    @Column(name = ENTITY_PREFIX + "_QUANTITY", nullable = false)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_FK")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_FK")
    private Product product;

    public static Trade createTrade(Member member, Product product, Integer quantity) {
        return Trade.builder()
                .member(member)
                .product(product)
                .quantity(quantity)
                .confirm(false)
                .build();
    }
}
