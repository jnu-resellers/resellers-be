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

    @Column(name = ENTITY_PREFIX + "_PRICE_UNIT", nullable = false)
    private Integer priceUnit;

    @Column(name = ENTITY_PREFIX + "_IS_SOLD", nullable = false)
    private Boolean isSold;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATERIAL_FK")
    private Material material;


    public static Auction createAuction(LocalDateTime deadline, Integer priceUnit, Material material, Boolean isSold) {
        return Auction.builder()
                .deadline(deadline)
                .priceUnit(priceUnit)
                .material(material)
                .isSold(isSold)
                .build();
    }
}
