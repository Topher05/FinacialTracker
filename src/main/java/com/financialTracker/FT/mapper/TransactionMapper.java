package com.financialTracker.FT.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.financialTracker.FT.dto.TransactionDTO;
import com.financialTracker.FT.model.Transaction;

@Mapper
public interface TransactionMapper {
	
	//Map Entity to DTO
	TransactionDTO toTransactionDTO(Transaction transaction);
	
	//Map DTO to Entity
	Transaction toTransaction(TransactionDTO transactionDTO);
	
	//Map List of transactions to List of transactionDTOs
	List<TransactionDTO> toTransactionDTOList(List<Transaction> transactions);
}
