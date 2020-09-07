package com.filehandler.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileServiceStore {
	
	public void store(MultipartFile file) throws Exception; //fileStorageException
	
	public Resource loadFile(String filename) throws Exception;

}
