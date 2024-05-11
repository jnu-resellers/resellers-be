package com.cap.resellers.product.repository;

import com.cap.resellers.product.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
