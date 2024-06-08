package com.cap.resellers.auction.service;

import com.cap.resellers.auction.dto.response.AuctionBidDto;
import com.cap.resellers.auction.dto.response.GetAuctionBidsResponse;
import com.cap.resellers.auction.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetAuctionBidsService {
    private final HistoryRepository historyRepository;
    @Transactional(readOnly = true)
    public GetAuctionBidsResponse getAuctionBids(Long auctionId) {
        return GetAuctionBidsResponse.of(historyRepository.findByAuctionId(auctionId).stream()
                .map(history -> AuctionBidDto.of(history.getMember().getName(), history.getPrice(), history.getCreatedDate()))
                .toList());
    }
}
