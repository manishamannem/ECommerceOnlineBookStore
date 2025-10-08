package com.nt.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.FilesEntity;

@Repository
public interface FileRepo extends JpaRepository<FilesEntity, Long>{

}
