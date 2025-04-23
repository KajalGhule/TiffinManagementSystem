package com.app.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.services.StorageService;

@CrossOrigin(origins="*")
@RestController
public class FileController {

	@Autowired
	private StorageService storageservice;
	
	
	@RequestMapping(value="/images/{fileName}",produces="image/*")
	public void downloadFile(@PathVariable("fileName") String fileName,HttpServletResponse response)throws IOException {
	
		try(FileInputStream in=new FileInputStream(new File("images",fileName)))
		{
			FileCopyUtils.copy(in, response.getOutputStream());
		}
		Resource resource=storageservice.load(fileName);
		FileCopyUtils.copy(resource.getInputStream(), response.getOutputStream());
	}
}
