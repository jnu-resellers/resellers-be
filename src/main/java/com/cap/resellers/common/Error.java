package com.cap.resellers.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {

    private String code;

    private String reason;

    private String status;

}
