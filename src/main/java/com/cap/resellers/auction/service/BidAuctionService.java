package com.cap.resellers.auction.service;

import com.cap.resellers.auction.dto.request.BidAuctionRequest;
import com.cap.resellers.auction.model.Auction;
import com.cap.resellers.auction.repository.AuctionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BidAuctionService {

    private final AuctionRepository auctionRepository;

    @Transactional
    public Integer execute(BidAuctionRequest request) {
        Auction auction = auctionRepository.findById(request.auctionId()).orElseThrow(NullPointerException::new);
        auction.bid(request.price());
        return auction.getNowPrice();
    }
}
