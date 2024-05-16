package com.cap.resellers.trade.service;

import com.cap.resellers.member.model.Member;
import com.cap.resellers.member.repository.MemberRepository;
import com.cap.resellers.product.model.Product;
import com.cap.resellers.product.repository.ProductRepository;
import com.cap.resellers.trade.dto.BuyProductDto;
import com.cap.resellers.trade.dto.CreateTradeRequest;
import com.cap.resellers.trade.dto.CreateTradeResponse;
import com.cap.resellers.trade.dto.SellerDto;
import com.cap.resellers.trade.model.Trade;
import com.cap.resellers.trade.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateTradeService {
    private final TradeRepository tradeRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    @Transactional
    public CreateTradeResponse execute(Long memberId, CreateTradeRequest request) {
        Member buyer = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("Member not found"));
        Member seller = memberRepository.findById(request.products().get(0).productId()).orElseThrow(() -> new IllegalArgumentException("Member not found"));

        checkBuyOwnProduct(buyer, seller);

        List<BuyProductDto> buyProducts = new ArrayList<>();
        List<Trade> trades = new ArrayList<>();

        int totalPrice = request.products().stream()
                .map(productDto -> productRepository.findById(productDto.productId())
                        .orElseThrow(() -> new IllegalArgumentException("Product not found")))
                .map(product -> {
                    addTrade(trades, buyer, product);
                    addBuyProductDto(buyProducts, product);
                    return product.getPrice();
                })
                .mapToInt(Integer::intValue)
                .sum();
        tradeRepository.saveAll(trades);
        return CreateTradeResponse.of(buyProducts, SellerDto.of(seller), totalPrice);
    }

    private void addBuyProductDto(List<BuyProductDto> buyProducts, Product product) {
        buyProducts.add(BuyProductDto.of(product.getName(), product.getPrice(), product.getDescription()));
    }

    private void addTrade(List<Trade> trades, Member buyer, Product product) {
        trades.add(Trade.builder()
                .member(buyer)
                .product(product)
                .confirm(false)
                .quantity(1)
                .build());
    }

    private void checkBuyOwnProduct(Member buyer, Member seller) {
        if (buyer.getId().equals(seller.getId())) {
            throw new IllegalArgumentException("Can't buy your own product");
        }
    }
}
