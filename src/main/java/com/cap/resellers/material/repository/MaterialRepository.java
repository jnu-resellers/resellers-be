package com.cap.resellers.material.repository;

import com.cap.resellers.material.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {

}
