package com.asif.springcloud.dto;

import java.math.BigDecimal;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Coupon {
	
	private Long id;
	private String code;
	private BigDecimal discount;
	private String expDate;

}
