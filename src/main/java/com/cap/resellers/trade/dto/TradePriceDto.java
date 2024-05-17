package com.cap.resellers.trade.dto;

import java.time.LocalDate;

public record TradePriceDto(LocalDate date, Long lowest, Long average) {
}
