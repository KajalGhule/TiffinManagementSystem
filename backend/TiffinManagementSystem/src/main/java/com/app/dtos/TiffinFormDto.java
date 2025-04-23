package com.app.dtos;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TiffinFormDto {

	private int tiffinId;
	
	private String tiffinName;
	
	private int tiffinPrice;
	
	private MultipartFile tiffinImage;
	
	private String description;
}
