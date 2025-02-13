package com.ssafy.bbanggu.util.image;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageService {
	private final String uploadDir = "/home/ubuntu/uploads/";

	public String saveImage(MultipartFile file) throws IOException {
		String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
		Path filePath = Paths.get(uploadDir + filename);

		// 디버깅 로그 추가
		System.out.println("💧 절대 경로: " + filePath.toAbsolutePath());
		System.out.println("💧 디렉토리 존재 여부: " + Files.exists(filePath.getParent()));

		Files.createDirectories(filePath.getParent());
		Files.write(filePath, file.getBytes());

		// 파일 저장 후 확인
		System.out.println("💧 파일 저장 후 존재 여부: " + Files.exists(filePath));
		System.out.println("💧 파일 크기: " + Files.size(filePath));

		return "/uploads/" + filename;
	}

}
