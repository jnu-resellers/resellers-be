package com.cap.resellers.trade.repository;

import com.cap.resellers.material.model.ItemType;
import com.cap.resellers.trade.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TradeRepository extends JpaRepository<Trade, Long> {

    List<Trade> findByItemType(ItemType itemType);

    List<Trade> findByItemTypeAndProductCreatedDateBetween(ItemType itemType, LocalDateTime startDate, LocalDateTime endDate);
}
