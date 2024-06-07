package com.cap.resellers.trade.repository;

import com.cap.resellers.material.model.ItemType;
import com.cap.resellers.trade.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TradeRepository extends JpaRepository<Trade, Long> {

    List<Trade> findByItemType(ItemType itemType);
    @Query("SELECT t FROM Trade t JOIN FETCH t.material tm JOIN FETCH tm.product tmp WHERE t.itemType = :itemType AND tmp.createdDate BETWEEN :startDate AND :endDate AND t.confirm = true")
    List<Trade> findByItemTypeAndProductCreatedDateBetween(ItemType itemType, LocalDateTime startDate, LocalDateTime endDate);

    List<Trade> findByBuyerId(Long memberId);
}
