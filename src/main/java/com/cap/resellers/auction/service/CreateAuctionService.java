package com.cap.resellers.auction.service;

import com.cap.resellers.auction.dto.request.CreateAuctionRequest;
import com.cap.resellers.auction.model.Auction;
import com.cap.resellers.auction.model.AuctionMember;
import com.cap.resellers.auction.model.UserRole;
import com.cap.resellers.auction.repository.AuctionMemberRepository;
import com.cap.resellers.auction.repository.AuctionRepository;
import com.cap.resellers.material.dto.ImageDTO;
import com.cap.resellers.material.model.Material;
import com.cap.resellers.material.service.CreateMaterialService;
import com.cap.resellers.member.model.Member;
import com.cap.resellers.product.model.Image;
import com.cap.resellers.product.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateAuctionService {
    private final CreateMaterialService createMaterialService;
    private final AuctionRepository auctionRepository;
    private final AuctionMemberRepository auctionMemberRepository;
@Transactional
    public List<ImageDTO> execute(CreateAuctionRequest request, Long memberId) {
        Member member = createMaterialService.getMember(memberId);
        List<Image> images = createMaterialService.createImages(request.fileNames());
        Product product = createMaterialService.createProduct(member, request.productName(), request.price(), request.description(), images, request.defect());
        Material material = createMaterialService.createMaterial(member, request.itemType(), product, request.contact());

        Auction auction = Auction.createAuction(LocalDateTime.now().plusDays(request.period()), request.priceUnit(), material, false);
        auctionRepository.save(auction);

        AuctionMember auctionMember = AuctionMember.createAuctionMember(auction, member, UserRole.SELLER);
        auctionMemberRepository.save(auctionMember);
        return ImageDTO.of(images, request.fileNames());
    }
}
