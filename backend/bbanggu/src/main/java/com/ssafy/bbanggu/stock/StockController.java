package com.ssafy.bbanggu.stock;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.bbanggu.bread.Bread;
import com.ssafy.bbanggu.bread.BreadDTO;

import lombok.RequiredArgsConstructor;
import org.webjars.NotFoundException;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {
	private final StockService stockService;

	// 재고 등록
	@PostMapping("")
	public ResponseEntity<String> insertStock(@RequestBody StockDTO stockDto) {
		Stock insertedStock = stockService.insertStock(stockDto);
		return ResponseEntity.ok("재고 등록 성공: ID = " + insertedStock.getStockId());
	}

	@PutMapping("")
	public ResponseEntity<String> updateStock(@RequestBody StockDTO stockDto) {
		Stock updatedStock = stockService.updateStock(stockDto);
		return ResponseEntity.ok("재고 수정 성공: ID = " + updatedStock.getStockId());
	}

	@GetMapping("/{stockId}")
	public ResponseEntity<?> getStock(@PathVariable("stockId") long stockId) {
		try {
			StockDTO stockDTO = stockService.getStock(stockId);
			return ResponseEntity.ok(stockDTO);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("재고 정보를 찾을 수 없습니다.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류가 발생했습니다.");
		}
	}



}
