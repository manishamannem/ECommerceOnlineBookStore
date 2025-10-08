package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class FilesEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(name = "fileName")
		private String fileName;
		@Column(name = "fileType")
		private String fileType;
		@Column(columnDefinition = "longblob")
		@Lob
		private byte[] data; 
		@CreationTimestamp
		@Column(name = "createdDate")
		public LocalDateTime createdDate;
		@UpdateTimestamp
		@Column(name = "updatedDate")
		public LocalDateTime updatedDate;

	
}
