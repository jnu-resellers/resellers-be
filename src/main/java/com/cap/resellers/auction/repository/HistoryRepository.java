package com.cap.resellers.auction.repository;

import com.cap.resellers.auction.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History,Long> {
    List<History> findByAuctionId(Long auctionId);
    List<History> findByMemberId(Long memberId);
}
