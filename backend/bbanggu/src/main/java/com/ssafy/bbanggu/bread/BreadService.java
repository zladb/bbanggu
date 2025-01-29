package com.ssafy.bbanggu.bread;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.bbanggu.bakery.Bakery;
import com.ssafy.bbanggu.util.image.ImageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BreadService {
	private final BreadRepository breadRepository;
	private final ImageService imageService;

	public Bread insertBread(BreadDTO breadDto, MultipartFile file) throws IOException {
		Bread bread = new Bread();

		// id 유효성 검사가 필요 없으면 아래 코드 적용(프록시 방식)
		Bakery bakery = new Bakery();
		bakery.setBakeryId(breadDto.getBakeryId());
		BreadCategory breadCategory = new BreadCategory();
		breadCategory.setBreadCategoryId(breadDto.getBreadCategoryId());

		// id 유효성 검사가 필요하면 아래 코드 적용
		// Bakery bakery = bakeryRepository.findById(breadDto.getBakeryId())
		// 	.orElseThrow(() -> new IllegalArgumentException("해당 bakeryId가 존재하지 않습니다."));
		// BreadCategory breadCategory = breadCategoryRepository.findById(breadDto.getBreadCategoryId())
		// 	.orElseThrow(() -> new IllegalArgumentException("해당 bakeryId가 존재하지 않습니다."));

		bread.setBakery(bakery);
		bread.setBreadCategory(breadCategory);
		bread.setName(breadDto.getName());
		bread.setPrice(breadDto.getPrice());
		bread.setCreatedAt(LocalDateTime.now());
		bread.setBreadImageUrl(imageService.saveImage(file));

		return breadRepository.save(bread);
	}

	public Bread getBread(long breadId) {
		return breadRepository.findById(breadId).orElse(null);
	}
}
