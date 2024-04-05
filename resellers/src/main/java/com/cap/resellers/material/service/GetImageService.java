package com.cap.resellers.material.service;

import com.cap.resellers.material.repository.S3Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetImageService {
    private final S3Repository s3Repository;

    @Transactional(readOnly = true)
    public Optional<String> execute(Long imageId) {
        return s3Repository.get(imageId);
    }

}
