package com.financialTracker.FT.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@AllArgsConstructor
public class TransactionDTO {
	
	private long id;
	private String name;
	private String description;
	private BigDecimal amount;
	private LocalDate date;
	private String category;
	
	
}
