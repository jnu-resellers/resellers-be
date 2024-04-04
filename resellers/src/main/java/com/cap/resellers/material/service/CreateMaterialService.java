package com.cap.resellers.material.service;

import com.cap.resellers.material.dto.CreateMaterialProductDTO;
import com.cap.resellers.material.dto.request.CreateMaterialRequest;
import com.cap.resellers.material.dto.request.ProductRequest;
import com.cap.resellers.material.model.JobType;
import com.cap.resellers.material.model.Material;
import com.cap.resellers.material.repository.MaterialRepository;
import com.cap.resellers.member.model.Member;
import com.cap.resellers.member.repository.MemberRepository;
import com.cap.resellers.product.model.Image;
import com.cap.resellers.product.model.Product;
import com.cap.resellers.product.repository.ImageRepository;
import com.cap.resellers.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateMaterialService {

    private final MaterialRepository materialRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;

    @Transactional
    public List<CreateMaterialProductDTO> execute(CreateMaterialRequest request, Long memberId) {
        Member member = memberRepository.save(Member.builder()
                .id(memberId)
                .name("test")
                .build());

        List<Product> productList = new ArrayList<>();

        for(ProductRequest productRequestDTO : request.products()) {
            List<Image> images = new ArrayList<>();
            for (String fileName : productRequestDTO.fileNames()) {
                images.add(Image.createImage());
            }
            imageRepository.saveAll(images);
            Product product = Product.createProduct(memberId, productRequestDTO.name(), productRequestDTO.price(), productRequestDTO.description(), images);
            productRepository.save(product);
            productList.add(product);
        }

        Material material = Material.createMaterial(member, request.title(), JobType.valueOf(request.jobType()), productList);
        material = materialRepository.save(material);

        List<CreateMaterialProductDTO> productDTOs = new ArrayList<>();

        for(Product product : productList) {
            CreateMaterialProductDTO productDTO = CreateMaterialProductDTO.of(material, product);
            productDTOs.add(productDTO);
        }

        return productDTOs;
    }

}
