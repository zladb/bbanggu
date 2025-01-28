package com.ssafy.bbanggu.bread;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.bbanggu.util.image.ImageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BreadService {
	private final BreadRepository breadRepository;
	private final ImageService imageService;

	public Bread insertBread(Bread bread, MultipartFile file) throws IOException {
		bread.setCreatedAt(LocalDateTime.now());
		bread.setBreadImageUrl(imageService.saveImage(file));

		return breadRepository.save(bread);
	}
}
