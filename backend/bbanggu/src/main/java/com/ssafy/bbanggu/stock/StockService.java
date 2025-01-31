package com.ssafy.bbanggu.stock;

import com.ssafy.bbanggu.bakery.Bakery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.bbanggu.bread.Bread;

import lombok.RequiredArgsConstructor;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class StockService {
	private final StockRepository stockRepository;

	// 재고 등록
	public Stock insertStock(StockDTO stockDto) {
		Stock stock = convertToEntity(stockDto);
		if (stockDto.getCreatedAt() != null) {
			stock.setCreatedAt(stockDto.getCreatedAt());
		} else {
			stock.setCreatedAt(LocalDateTime.now());
		}
		return stockRepository.save(stock);
	}

	// 재고 개별조회
	public StockDTO getStock(long stockId) {
		Stock stock = stockRepository.findById(stockId)
			.orElseThrow(() -> new NotFoundException("Stock not found with id: " + stockId));
		return convertToDTO(stock);
	}

	public Stock updateStock(StockDTO stockDto) {
		Stock stock = stockRepository.findById(stockDto.getStockId()).orElseThrow(() -> new RuntimeException("stock not found"));
		// 업데이트
		return stockRepository.save(stock);
	}

	public void deleteStock(long stockId) {
		Stock stock = stockRepository.findById(stockId).orElseThrow(() -> new RuntimeException("stock not found"));
		stock.setDeletedAt(LocalDateTime.now());
	}


	/* ============== 유틸 ============== */
	private StockDTO convertToDTO(Stock stock) {
		StockDTO stockDTO = new StockDTO();
		stockDTO.setStockId(stock.getStockId());
		stockDTO.setQuantity(stock.getQuantity());
		stockDTO.setBreadId(stock.getBread().getBreadId());
		stockDTO.setBakeryId(stock.getBakery().getBakeryId());
		stockDTO.setCreatedAt(stock.getCreatedAt());
		return stockDTO;
	}

	private Stock convertToEntity(StockDTO stockDto) {
		Stock stock = new Stock();

		// id 유효성 검사 안하는 코드임. 필요시 수정해야함.
		Bakery bakery = new Bakery();
		Bread bread = new Bread();
		bakery.setBakeryId(stockDto.getBakeryId());
		bread.setBreadId(stockDto.getBreadId());

		stock.setBakery(bakery);
		stock.setBread(bread);
		stock.setQuantity(stockDto.getQuantity());
		stock.setCreatedAt(stockDto.getCreatedAt());
		return stock;
	}
}
