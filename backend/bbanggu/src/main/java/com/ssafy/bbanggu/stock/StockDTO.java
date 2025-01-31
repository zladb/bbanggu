package com.ssafy.bbanggu.stock;

import com.ssafy.bbanggu.bakery.Bakery;
import com.ssafy.bbanggu.bread.Bread;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StockDTO {
	private Long stockId;
	private Long bakeryId;
	private Long breadId;
	private Integer quantity;
	private LocalDateTime createdAt;
}
