package com.cap.resellers.material.service;

import com.cap.resellers.material.dto.ImageDTO;
import com.cap.resellers.material.dto.ImageDTO;
import com.cap.resellers.material.dto.request.CreateMaterialRequest;
import com.cap.resellers.material.model.ItemType;
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
    public List<ImageDTO> execute(CreateMaterialRequest request, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(NullPointerException::new);

        List<Image> images = new ArrayList<>();
        request.fileNames().forEach(fileName -> {
            Image image = Image.createImage();
            imageRepository.save(image);
            images.add(image);
        });

        Product product = Product.createProduct(memberId, request.productName(), request.price(), request.description(), images, request.defect());
        productRepository.save(product);

        Material material = Material.createMaterial(member, ItemType.fromValue(request.itemType()), product, request.contact());
        materialRepository.save(material);

        return ImageDTO.of(images, request.fileNames());
    }

}
