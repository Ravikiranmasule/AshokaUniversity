package com.ashokclass.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EnquiryStatusEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer statusId;
	private Integer statusName;

}
