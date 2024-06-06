package com.cap.resellers.auction.service;

import com.cap.resellers.auction.dto.request.BidAuctionRequest;
import com.cap.resellers.auction.model.Auction;
import com.cap.resellers.auction.model.History;
import com.cap.resellers.auction.repository.AuctionRepository;
import com.cap.resellers.auction.repository.HistoryRepository;
import com.cap.resellers.member.model.Member;
import com.cap.resellers.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BidAuctionService {

    private final AuctionRepository auctionRepository;
    private final MemberRepository memberRepository;
    private final HistoryRepository historyRepository;

    @Transactional
    public Integer execute(BidAuctionRequest request) {
        Auction auction = auctionRepository.findById(request.auctionId()).orElseThrow(NullPointerException::new);
        Member member = memberRepository.findById(request.memberId()).orElseThrow(NullPointerException::new);
        // Auction을 올린 사람과 입찰하는 사람이 같은지 확인
        if(auction.getMaterial().getMember().getId().equals(request.memberId())){
            throw new IllegalArgumentException("경매를 올린 사람은 입찰할 수 없습니다.");
        };

        auction.bid(request.price());
        History history = History.createHistory(request.price(), member, auction);
        historyRepository.save(history);
        return auction.getNowPrice();
    }
}
