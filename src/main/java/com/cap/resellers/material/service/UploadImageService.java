package com.cap.resellers.material.service;

import com.cap.resellers.material.dto.ImageDTO;
import com.cap.resellers.material.repository.S3Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UploadImageService {
    public static final List<String> FILE_EXTS = List.of("jpg", "jpeg", "png");
    public final S3Repository s3Repository;

    @Transactional
    public Map<Long, String> execute(List<ImageDTO> imageDTOS) {
        Map<Long, String> imageMap = new HashMap<>();
        for(ImageDTO imageDTO : imageDTOS) {
            validateExt(imageDTO.fileName());
            String presignedUrl = s3Repository.put(imageDTO);
            imageMap.put(imageDTO.imageId(), presignedUrl);
        }
        return imageMap;
    }

    private void validateExt(String fileName) {
        int pos = fileName.lastIndexOf(".");
        String ext = fileName.substring(pos + 1);
        if (!FILE_EXTS.contains(ext)) {
            throw new IllegalArgumentException("올바르지 않은 확장자입니다.");
        }
    }
}
