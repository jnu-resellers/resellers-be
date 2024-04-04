package com.cap.resellers.material.controller;

import com.cap.resellers.common.ApiResponse;
import com.cap.resellers.common.ApiResponseGenerator;
import com.cap.resellers.material.dto.CreateMaterialProductDTO;
import com.cap.resellers.material.dto.ImageDTO;
import com.cap.resellers.material.dto.request.CreateMaterialRequest;
import com.cap.resellers.material.dto.response.CreateMaterialResponse;
import com.cap.resellers.material.service.CreateMaterialService;
import com.cap.resellers.material.service.UploadImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MaterialController {

    private final CreateMaterialService createMaterialService;
    private final UploadImageService uploadImageService;
    @PostMapping("/board/material")
    public ApiResponse<ApiResponse.CustomBody<Void>> createMaterial(@RequestBody CreateMaterialRequest request) {
        Long memberId = 1L;
        List<CreateMaterialProductDTO> createMaterialProductDTOS = createMaterialService.execute(request, memberId);
        Map<Long, String> imageUrlMap = uploadImageService.execute(ImageDTO.of(request, createMaterialProductDTOS));
        return ApiResponseGenerator.success(CreateMaterialResponse.of(createMaterialProductDTOS,imageUrlMap),HttpStatus.CREATED);
    }
}
