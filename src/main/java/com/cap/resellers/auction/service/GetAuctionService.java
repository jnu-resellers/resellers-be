package com.cap.resellers.auction.service;

import com.cap.resellers.auction.dto.response.GetAuctionResponse;
import com.cap.resellers.auction.model.Auction;
import com.cap.resellers.auction.repository.AuctionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetAuctionService {

    private final AuctionRepository auctionRepository;

    @Transactional(readOnly = true)
    public GetAuctionResponse execute(Long auctionId) {
        Auction auction = auctionRepository.findById(auctionId).orElseThrow(NullPointerException::new);
        return GetAuctionResponse.of(auction);
    }


}
