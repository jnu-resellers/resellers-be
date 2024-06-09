package com.cap.resellers.auction.repository;

import com.cap.resellers.auction.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
    @Query("select a from Auction a join fetch a.material m where m.member.id = :memberId")
    List<Auction> findByMemberId(Long memberId);
}
