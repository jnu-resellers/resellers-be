package com.cap.resellers.trade.service;

import com.cap.resellers.trade.model.Trade;
import com.cap.resellers.trade.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CompleteTradeService {
    private final TradeRepository tradeRepository;

    @Transactional
    public void execute(Long tradeId) {
        Trade trade = tradeRepository.findById(tradeId)
                .orElseThrow(() -> new IllegalArgumentException("해당 거래가 존재하지 않습니다."));
        trade.completeTrade();
        trade.getProduct().sold();
    }

}
