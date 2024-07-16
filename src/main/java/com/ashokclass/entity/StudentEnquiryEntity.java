package com.ashokclass.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
@Entity
public class StudentEnquiryEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer enquiryId;
	private String studentName;
	private Long phoneNumber;
	private String classMode;
	private String courseName;
	private String courseStatus;
	
	
	@CreationTimestamp
	@Column(updatable = false)
	private Date createdDate;
	@UpdateTimestamp
	@Column(insertable = false)
	private Date updatedDate;
	@ManyToOne
	private UserDetailsEntity user;

}
