package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface StorageService {

	List<String> loadAll();
	String store(MultipartFile file);
	Resource load(String fileName);
	void delete(String fileName);
}
