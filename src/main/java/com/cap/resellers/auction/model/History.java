package com.cap.resellers.auction.model;

import com.cap.resellers.common.BaseEntity;
import com.cap.resellers.member.model.Member;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = History.ENTITY_PREFIX + "_TB")
@Builder()
public class History extends BaseEntity {
    public static final String ENTITY_PREFIX = "HISTORY";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_PK", nullable = false)
    private Long id;

    @Column(name = ENTITY_PREFIX + "_PRICE", nullable = false)
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_FK")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUCTION_FK")
    private Auction auction;

    public static History createHistory(Integer price, Member member, Auction auction) {
        return History.builder()
                .price(price)
                .member(member)
                .auction(auction)
                .build();
    }
}
