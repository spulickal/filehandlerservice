package com.filehandler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filehandler.entity.Metadata;

@Repository
public interface MetaDataRepository extends JpaRepository <Metadata, Long> {

}
