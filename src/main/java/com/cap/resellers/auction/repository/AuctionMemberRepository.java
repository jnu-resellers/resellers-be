package com.cap.resellers.auction.repository;

import com.cap.resellers.auction.model.AuctionMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionMemberRepository extends JpaRepository<AuctionMember, Long> {
}
