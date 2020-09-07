package com.filehandler.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filehandler.entity.Metadata;
import com.filehandler.repository.MetaDataRepository;
import com.filehandler.service.MetaDataStore;

@Service
public class FileMetaDataDBStore implements MetaDataStore {

	@Autowired
	MetaDataRepository metadataRepository;
	
	@Override
	public void save(Metadata metadata) {
		
		metadataRepository.save(metadata);
	}
	
	public Optional<Metadata> findById(Long id) {
		
		return metadataRepository.findById(id);
	}

}
