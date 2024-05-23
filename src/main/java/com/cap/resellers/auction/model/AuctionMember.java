package com.cap.resellers.auction.model;

import com.cap.resellers.member.model.Member;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = AuctionMember.ENTITY_PREFIX + "_TB")
@Builder()
public class AuctionMember {
    public static final String ENTITY_PREFIX = "AUCTION_MEMBER";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_PK", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = ENTITY_PREFIX + "_USER_ROLE", nullable = false)
    private UserRole userRole;

    @ManyToOne
    @JoinColumn(name = "AUCTION_FK")
    private Auction auction;

    @ManyToOne
    @JoinColumn(name = "MEMBER_FK")
    private Member member;


    public static AuctionMember createAuctionMember(Auction auction, Member member, UserRole userRole) {
        return AuctionMember.builder()
                .auction(auction)
                .member(member)
                .userRole(userRole)
                .build();
    }
}
