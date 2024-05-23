package com.cap.resellers.auction.model;

import com.cap.resellers.material.model.Material;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = Auction.ENTITY_PREFIX + "_TB")
@Builder()
public class Auction {
    public static final String ENTITY_PREFIX = "AUCTION";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_PK", nullable = false)
    private Long id;

    @Column(name = ENTITY_PREFIX + "_DEADLINE", nullable = false)
    private LocalDateTime deadline;

    @Column(name = ENTITY_PREFIX + "_START_AT", nullable = false)
    private LocalDateTime startAt;

    @Column(name = ENTITY_PREFIX + "_PRICE_UNIT", nullable = false)
    private Integer priceUnit;

    @Column(name = ENTITY_PREFIX + "_IS_SOLD", nullable = false)
    private Boolean isSold;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATERIAL_FK")
    private Material material;

    @Column(name = ENTITY_PREFIX + "_BID_COUNT", nullable = false)
    private Integer bidCount;

    @Column(name = ENTITY_PREFIX + "_NOW_PRICE", nullable = false)
    private Integer nowPrice;

    public static Auction createAuction(LocalDateTime deadline, Integer priceUnit, Material material, Boolean isSold) {
        return Auction.builder()
                .nowPrice(material.getProduct().getPrice())
                .bidCount(0)
                .startAt(LocalDateTime.now())
                .deadline(deadline)
                .priceUnit(priceUnit)
                .material(material)
                .isSold(isSold)
                .build();
    }

    public void bid(Integer price) {
        if(nowPrice > price) {
            throw new IllegalArgumentException("현재 가격보다 높은 가격을 입력해주세요.");
        }
        nowPrice = price;
        bidCount++;
    }
}
