package com.cap.resellers.trade.service;

import com.cap.resellers.material.model.Material;
import com.cap.resellers.material.repository.MaterialRepository;
import com.cap.resellers.member.model.Member;
import com.cap.resellers.member.repository.MemberRepository;
import com.cap.resellers.product.model.Product;
import com.cap.resellers.product.repository.ProductRepository;
import com.cap.resellers.trade.dto.BuyProductDto;
import com.cap.resellers.trade.dto.reqeust.CreateTradeRequest;
import com.cap.resellers.trade.dto.response.CreateTradeResponse;
import com.cap.resellers.trade.dto.response.GetTradeResponse;
import com.cap.resellers.trade.dto.SellerDto;
import com.cap.resellers.trade.model.Trade;
import com.cap.resellers.trade.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateTradeService {
    private final TradeRepository tradeRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final MaterialRepository materialRepository;

    @Transactional
    public CreateTradeResponse execute(Long memberId, CreateTradeRequest request) {
        Member buyer = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("Member not found"));
        Product product = productRepository.findById(request.productId()).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        Member seller = product.getSeller();
        Material material = materialRepository.findById(request.materialId()).orElseThrow(() -> new IllegalArgumentException("Material not found"));

        checkBuyOwnProduct(buyer, seller);

        Trade trade = Trade.createTrade(buyer, material, request.quantity(), material.getItemType());
        tradeRepository.save(trade);
        return CreateTradeResponse.from(request.materialId(), trade.getId());
    }

    private void checkBuyOwnProduct(Member buyer, Member seller) {
        if (buyer.getId().equals(seller.getId())) {
            throw new IllegalArgumentException("자신의 상품은 주문 신청 할 수 없습니다.");
        }
    }
}
