package com.financialTracker.FT.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.financialTracker.FT.dto.TransactionDTO;
import com.financialTracker.FT.model.Transaction;
import com.financialTracker.FT.service.TransactionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/FT/transactions")
@RequiredArgsConstructor
public class TransactionController {
	
	private final TransactionService transactionService;
	
	
	@GetMapping("/{id}")
	public TransactionDTO getTransaction(@PathVariable Long id ) {
		return transactionService.getTransactionById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TransactionDTO createTransaction(@RequestBody @Valid TransactionDTO transactionDTO) {	
		return transactionService.createTransaction(transactionDTO);
	}
	
	@GetMapping
	public List<TransactionDTO> getAllTransactions(){
		return transactionService.getAllTransactions();
	}
	
}
