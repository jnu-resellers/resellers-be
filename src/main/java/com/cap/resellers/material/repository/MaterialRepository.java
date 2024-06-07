package com.cap.resellers.material.repository;

import com.cap.resellers.material.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {

    List<Material> findByMemberId(Long memberId);
}
