package com.financialTracker.FT.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.financialTracker.FT.dto.TransactionDTO;
import com.financialTracker.FT.mapper.TransactionMapper;
import com.financialTracker.FT.model.Transaction;
import com.financialTracker.FT.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class TransactionService {
	
	private final TransactionRepository transactionRepo;
	private final TransactionMapper transactionMapper;
	

	//creates a new Transaction
	public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
		Transaction transactionToBeAdded = transactionMapper.toTransaction(transactionDTO);
		
		Transaction transaction = transactionRepo.save(transactionToBeAdded);
		return transactionMapper.toTransactionDTO(transaction);
		
	}
	
	public List<TransactionDTO> getAllTransactions() {
		List<Transaction> transactions = transactionRepo.findAll();
		return transactionMapper.toTransactionDTOList(transactions);
	}
}
