package com.ashokclass.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class UserDetailsEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private String userEmail;
	private Long userPhoneNumber;
	private String userPassword;
	private String accountStatus;
	@OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<StudentEnquiryEntity> enquiries;
	

}
