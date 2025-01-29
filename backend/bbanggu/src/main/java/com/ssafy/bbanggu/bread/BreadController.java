package com.ssafy.bbanggu.bread;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/bread")
public class BreadController {

	private final BreadService breadService;

	public BreadController(BreadService breadService) {
		super();
		this.breadService = breadService;
	}

	@PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> insertBread(@RequestPart("bread") String breadDtoJson,
		@RequestPart(value = "image", required = false) MultipartFile file) {
		try {
			System.out.println("dto: " + breadDtoJson);
			ObjectMapper objectMapper = new ObjectMapper();
			BreadDTO breadDto = objectMapper.readValue(breadDtoJson, BreadDTO.class);
			Bread insertedBread = breadService.insertBread(breadDto, file);
			return ResponseEntity.ok("빵 등록 성공: ID = " + insertedBread.getBreadId());
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("빵 등록 실패");
		}
	}

	@GetMapping("/{breadId}")
	public ResponseEntity<?> getBread(@PathVariable("breadId") long breadId) {
		try {
			Bread bread = breadService.getBread(breadId);
			if (bread != null) {
				BreadDTO breadDto = new BreadDTO();
				breadDto.setBreadCategoryId(bread.getBreadCategory().getBreadCategoryId());
				breadDto.setName(bread.getName());
				breadDto.setPrice(bread.getPrice());
				breadDto.setBakeryId(bread.getBakery().getBakeryId());
				String imageUrl = bread.getBreadImageUrl().replace("\\", "/");
				breadDto.setBreadImageUrl(imageUrl);
				return ResponseEntity.ok(breadDto);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("빵 정보를 찾을 수 없습니다.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류가 발생했습니다.");
		}
	}

}
