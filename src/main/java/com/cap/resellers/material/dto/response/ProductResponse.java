package com.cap.resellers.material.dto.response;

import lombok.Builder;
import java.util.List;

public record ProductResponse(
        String name,
        List<String> presignedUrls
) {
    @Builder
    public ProductResponse {
    }

}
