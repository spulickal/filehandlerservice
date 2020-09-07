package com.filehandler.business.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.filehandler.business.FileHandler;
import com.filehandler.entity.Metadata;
import com.filehandler.exception.DataNotFoundException;
import com.filehandler.service.FileServiceStore;
import com.filehandler.service.MetaDataStore;

@Component
public class FileHandlerImpl implements FileHandler {
	
	@Autowired
	private FileServiceStore fileStore;
	
	@Autowired
	private MetaDataStore metadataStore;
	
	@Autowired
	ObjectMapper objectMapper;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void fileUpload(MultipartFile file, Metadata metadata) {
		
		try {
			fileStore.store(file);
			
			metadataStore.save(metadata);
			
		} catch (Exception e) {
			logger.error("Error in persisting file");
		}
		
	}
	
	//retrieve file metadata by fileId
	public Metadata findById(Long id) throws Exception {
		Optional<Metadata> metadata = metadataStore.findById(id);
		
		if(metadata.isPresent()) {
			return metadata.get();
		} 
		
		throw new DataNotFoundException("Failed to retrive file metadata");
		
	}
}
