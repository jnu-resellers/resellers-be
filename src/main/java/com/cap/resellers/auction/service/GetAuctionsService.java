package com.cap.resellers.auction.service;

import com.cap.resellers.auction.dto.GetMaterialsRegisterAuctionDto;
import com.cap.resellers.auction.dto.RegisterAuctionStatus;
import com.cap.resellers.auction.dto.response.GetAuctionsResponse;
import com.cap.resellers.auction.dto.response.GetOwnAuctionResponse;
import com.cap.resellers.auction.model.Auction;
import com.cap.resellers.auction.repository.AuctionRepository;
import com.cap.resellers.auction.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAuctionsService {

    private final AuctionRepository auctionRepository;
    private final HistoryRepository historyRepository;


    // 경매 목록 조회시 bidCount가 높은순으로 정렬해서 반환
    // 경매 목록 조회시 endAt이 현재 시간보다 이전인 경매는 제외하고 반환
    // 경매 목록 조회시 isSold가 true인 경매는 제외하고 반환

    @Transactional(readOnly = true)
    public GetAuctionsResponse execute(String sortType) {
        if(sortType == null) {
            List<Auction> auctions = auctionRepository.findAll().stream()
                    .filter(auction -> auction.getDeadline().isAfter(LocalDateTime.now()))
                    .filter(auction -> !auction.getIsSold())
                    .sorted((a1, a2) -> a2.getBidCount().compareTo(a1.getBidCount()))
                    .toList();
            return GetAuctionsResponse.of(auctions);
        }
        List<Auction> auctions = auctionRepository.findAll().stream()
                .filter(auction -> auction.getDeadline().isAfter(LocalDateTime.now()))
                .filter(auction -> !auction.getIsSold())
                .filter(auction -> auction.getMaterial().getItemType().getValue().equals(sortType))
                .sorted((a1, a2) -> a2.getBidCount().compareTo(a1.getBidCount()))
                .toList();
        return GetAuctionsResponse.of(auctions);
    }

    @Transactional(readOnly = true)
    public List<GetMaterialsRegisterAuctionDto> executeByMemberId(Long memberId) {
        return auctionRepository.findByMemberId(memberId).stream()
                .map(auction -> GetMaterialsRegisterAuctionDto.of(auction.getMaterial().getProduct().getImages().stream().findFirst().get().getFileName(),
                        auction.getMaterial(),auction.getNowPrice(), auction, checkAuctionStatus(auction)))
                .toList();
    }

   private RegisterAuctionStatus checkAuctionStatus(Auction auction) {
        if(auction.getDeadline().isAfter(LocalDateTime.now()))
            return RegisterAuctionStatus.FOR_SALE;
        else if(historyRepository.findByAuctionId(auction.getId()).isEmpty())
            return RegisterAuctionStatus.FAIL_BID;
        else
            return RegisterAuctionStatus.SUCCESS_BID;
   }
}
