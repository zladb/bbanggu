package com.ssafy.bbanggu.bread;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@PostMapping("")
	public ResponseEntity<String> insertBread(@RequestPart("bread") String breadJson,
		@RequestPart(value = "image", required = false) MultipartFile file) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Bread bread = objectMapper.readValue(breadJson, Bread.class);
			Bread insertedBread = breadService.insertBread(bread, file);
			return ResponseEntity.ok("빵 등록 성공: ID = " + insertedBread.getBreadId());
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("빵 등록 실패");
		}
	}

}
