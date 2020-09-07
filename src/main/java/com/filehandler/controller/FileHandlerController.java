package com.filehandler.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.filehandler.business.FileHandler;
import com.filehandler.entity.Metadata;
import com.filehandler.exception.FileException;

@RestController
@RequestMapping("/file")
public class FileHandlerController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FileHandler fileHandler;
	
	@PostMapping(value="/upload")
	@ResponseStatus(HttpStatus.OK)
	public void uploadFile(final @RequestParam("file") MultipartFile file, @RequestParam("metadata") String metadata) throws Exception {
		logger.info("uploadFile >>");
		
		Metadata metadataObj = null;
		try {
			metadataObj = new ObjectMapper().readValue(metadata, Metadata.class);
			System.out.println(metadataObj.getTag());
		
		
			fileHandler.fileUpload(file, metadataObj);
		
		} catch (Exception e) {
			
			throw new FileException("Error while uploading the file");
		}
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Metadata> findById(@PathVariable("id") Long id) throws Exception {
		
		logger.info("findById >> id: {}", id);
		Metadata metadata = fileHandler.findById(id);
		
		return new ResponseEntity<>(metadata, HttpStatus.OK);
	}
}
