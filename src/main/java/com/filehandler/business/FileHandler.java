package com.filehandler.business;

import org.springframework.web.multipart.MultipartFile;

import com.filehandler.entity.Metadata;


public interface FileHandler {
	
	public void fileUpload(MultipartFile file, Metadata metadata);
	public Metadata findById(Long id) throws Exception;
}
