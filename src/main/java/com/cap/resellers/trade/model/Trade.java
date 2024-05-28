package com.cap.resellers.trade.model;

import com.cap.resellers.common.BaseEntity;
import com.cap.resellers.material.model.ItemType;
import com.cap.resellers.material.model.Material;
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

    @Column(name = ENTITY_PREFIX + "_ITEM_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_FK")
    private Member buyer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATERIAL_FK")
    private Material material;

    public static Trade createTrade(Member buyer, Material material, Integer quantity, ItemType itemType) {
        return Trade.builder()
                .buyer(buyer)
                .material(material)
                .quantity(quantity)
                .confirm(false)
                .itemType(itemType)
                .build();
    }

    public void completeTrade() {
        this.confirm = true;
    }
}
