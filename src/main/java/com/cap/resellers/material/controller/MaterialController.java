package com.cap.resellers.material.controller;

import com.cap.resellers.common.ApiResponse;
import com.cap.resellers.common.ApiResponseGenerator;
import com.cap.resellers.material.dto.ImageDTO;
import com.cap.resellers.material.dto.request.CreateMaterialRequest;
import com.cap.resellers.material.dto.response.CreateMaterialResponse;
import com.cap.resellers.material.dto.response.GetMaterialResponse;
import com.cap.resellers.material.dto.response.GetMaterialsResponse;
import com.cap.resellers.material.model.ItemType;
import com.cap.resellers.material.service.CreateMaterialService;
import com.cap.resellers.material.service.GetMaterialService;
import com.cap.resellers.material.service.GetMaterialsService;
import com.cap.resellers.material.service.UploadImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "기자재(게시글)", description = "Material API")
public class MaterialController {

    private final CreateMaterialService createMaterialService;
    private final UploadImageService uploadImageService;
    private final GetMaterialsService getMaterialsService;
    private final GetMaterialService getMaterialService;
    @Tag(name = "기자재(게시글)", description = "Material API")
    @PostMapping("/board/material")
    public ApiResponse<ApiResponse.CustomBody<CreateMaterialResponse>> createMaterial(@RequestBody CreateMaterialRequest request) {
        Long memberId = 1L;
        List<ImageDTO> imageDTOS = createMaterialService.execute(request, memberId);
        Map<Long, String> imageUrlMap = uploadImageService.execute(imageDTOS);
        return ApiResponseGenerator.success(CreateMaterialResponse.of(imageUrlMap),HttpStatus.CREATED);
    }

    @Operation(summary = "기자재 목록 조회", description = "기자재 목록을 조회합니다.")
    @GetMapping("/board/materials")
    public ApiResponse<ApiResponse.CustomBody<GetMaterialsResponse>> getMaterials() {
        GetMaterialsResponse response = getMaterialsService.execute();
        return ApiResponseGenerator.success(response,HttpStatus.OK);
    }

    @Operation(summary = "기자재 상세 조회", description = "기자재 상세를 조회합니다.")
    @GetMapping("/board/materials/{materialId}")
    public ApiResponse<ApiResponse.CustomBody<GetMaterialResponse>> getMaterial(@PathVariable Long materialId) {
        GetMaterialResponse response = getMaterialService.execute(materialId);
        return ApiResponseGenerator.success(response,HttpStatus.OK);
    }

    @Operation(summary = "기가재 카테고리 조회", description = "기자재 카테고리를 조회합니다.")
    @GetMapping("/board/materials/category")
    public ApiResponse<ApiResponse.CustomBody<List<String>>> getMaterialCategory() {
        List<String> itemTypes = Arrays.stream(ItemType.values()).map(itemType -> itemType.getValue()).toList();
        return ApiResponseGenerator.success(itemTypes,HttpStatus.OK);
    }
}
