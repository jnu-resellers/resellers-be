package com.cap.resellers.material.service;

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
    public List<ImageDTO> execute(CreateMaterialRequest request) {
        Member member = getMember(request.memberId());
        List<Image> images = createImages(request.fileNames());
        Product product = createProduct(member, request.productName(), request.price(), request.description(), images, request.defect());
        createMaterial(member, request.itemType(), product, request.contact());

        return ImageDTO.of(images, request.fileNames());
    }

    @Transactional(readOnly = true)
    public Member getMember(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(NullPointerException::new);
    }

    @Transactional(readOnly = true)
    public List<Image> createImages(List<String> fileNames) {
        List<Image> images = new ArrayList<>();
        fileNames.forEach(fileName -> {
            Image image = Image.createImage(fileName);
            imageRepository.save(image);
            images.add(image);
        });
        return images;
    }

    @Transactional(readOnly = true)
    public Product createProduct(Member member, String productName, Integer price, String description, List<Image> images, String defect) {
        Product product = Product.createProduct(member, productName, price, description, images, defect);
        productRepository.save(product);
        return product;
    }

    @Transactional(readOnly = true)
    public Material createMaterial(Member member, String itemType, Product product, String contact) {
        Material material = Material.createMaterial(member, ItemType.fromValue(itemType), product, contact);
        materialRepository.save(material);
        return material;
    }
}

