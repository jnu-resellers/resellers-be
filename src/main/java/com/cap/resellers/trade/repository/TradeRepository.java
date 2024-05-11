package com.cap.resellers.trade.repository;

import com.cap.resellers.trade.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TradeRepository extends JpaRepository<Trade, Long> {
    List<Trade> findByMemberId(Long memberId);
}
