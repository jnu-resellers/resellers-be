package com.cap.resellers.trade.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record TradePriceDto(@JsonFormat(pattern = "yyyy-MM-dd") LocalDateTime date, Long lowest, Long average) {
}
