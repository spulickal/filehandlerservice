package com.filehandler.service;

import java.util.Optional;

import com.filehandler.entity.Metadata;

public interface MetaDataStore {
	
	public void save(Metadata metaData);
	
	public Optional<Metadata> findById(Long id);
}
