package com.cap.resellers.auction.service;

import com.cap.resellers.auction.dto.BidAuctionStatus;
import com.cap.resellers.auction.dto.GetMaterialsBidAuctionDto;
import com.cap.resellers.auction.dto.response.AuctionBidDto;
import com.cap.resellers.auction.dto.response.GetAuctionBidsResponse;
import com.cap.resellers.auction.model.Auction;
import com.cap.resellers.auction.model.History;
import com.cap.resellers.auction.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<GetMaterialsBidAuctionDto> executeByMemberId(Long memberId) {
        Map<Auction, List<History>> histories = historyRepository.findByMemberId(memberId).stream()
                .collect(Collectors.groupingBy(History::getAuction));
        List<GetMaterialsBidAuctionDto> response = new ArrayList<>();
        histories.forEach((auction, history) -> response.add(createDto(histories, auction)));
        return response;
    }

    private GetMaterialsBidAuctionDto createDto(Map<Auction, List<History>> histories, Auction auction) {
        return histories.get(auction).stream().max(Comparator.comparing(History::getPrice))
                .map(history1 -> GetMaterialsBidAuctionDto.of(history1.getAuction().getMaterial().getProduct().getImages().stream().findFirst().get().getFileName()
                        , history1.getAuction().getMaterial(), history1.getAuction().getNowPrice(), history1.getPrice(), history1.getAuction(), checkAuctionStatus(history1))).get();
    }

    private BidAuctionStatus checkAuctionStatus(History history) {
        if (history.getAuction().getDeadline().isAfter(LocalDateTime.now()) && history.getPrice().equals(history.getAuction().getNowPrice()))
            return BidAuctionStatus.BID;
        else if (history.getPrice().equals(history.getAuction().getNowPrice()))
            return BidAuctionStatus.SUCCESS_BID;
        else
            return BidAuctionStatus.FAIL_BID;
    }
}
