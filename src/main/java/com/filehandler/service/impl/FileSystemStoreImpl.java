package com.filehandler.service.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.filehandler.service.FileServiceStore;

@Service
public class FileSystemStoreImpl implements FileServiceStore {
	
	@Value("${file.destination.path}")
	private String fileDestination;
	
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Override
	public void store(MultipartFile file) throws Exception {
		final Path location = Paths.get(fileDestination);
		Files.copy(file.getInputStream(), location.resolve(file.getOriginalFilename()));
		file.getOriginalFilename();
	}
	
	@Override
	public Resource loadFile(String filename) throws Exception {
		final Path location = Paths.get(fileDestination);
		Path file = location.resolve(filename);
		Resource resource = new UrlResource(file.toUri());
		if(resource.exists() && resource.isFile()) {
			return resource;
		}
		throw new Exception();
	}
}
