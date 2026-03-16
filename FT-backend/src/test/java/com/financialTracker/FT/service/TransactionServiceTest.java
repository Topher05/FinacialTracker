package com.financialTracker.FT.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.financialTracker.FT.dto.TransactionDTO;
import com.financialTracker.FT.mapper.TransactionMapper;
import com.financialTracker.FT.model.Transaction;
import com.financialTracker.FT.repository.TransactionRepository;

//Initializes the Mocks and is faster than @SpringBootTest because it doesn't load the whole Spring Context.
@ExtendWith(MockitoExtension.class) 
public class TransactionServiceTest {
 
	@Mock
	private TransactionRepository transactionRepo;
	
	@Mock
	private TransactionMapper transactionMapper;
	
	@InjectMocks
	private TransactionService transactionService;
	
	@Test
	void testCreateTransaction() {
		TransactionDTO inputDto = new TransactionDTO(null, "Food", "Lunch", BigDecimal.TEN, LocalDate.now(), "Food");
		Transaction mappedEntity = new Transaction(1L, "Food", "Lunch", BigDecimal.TEN, LocalDate.now(), "Food");
		Transaction savedEntity = new Transaction(1L, "Food", "Lunch", BigDecimal.TEN, LocalDate.now(), "Food");
		TransactionDTO outputDto = new TransactionDTO(1L, "Food", "Lunch", BigDecimal.TEN, LocalDate.now(), "Food");
		
		//tells the Mocks what to do when it runs into the mapper or repository
		when(transactionMapper.toTransaction(inputDto)).thenReturn(mappedEntity);
		when(transactionRepo.save(any(Transaction.class))).thenReturn(savedEntity);
		when(transactionMapper.toTransactionDTO(savedEntity)).thenReturn(outputDto);
		
		//runs the method
		TransactionDTO result = transactionService.createTransaction(inputDto);
		
		//verifies the results
		assertNotNull(result);
		assertEquals(1L, result.getId());
		assertEquals("Lunch", result.getDescription());
		
		verify(transactionRepo, times(1)).save(any(Transaction.class));
	}
	
	@Test
	void testGetTransactionById() {
		Long id = 1L;
		Transaction transaction = new Transaction(id, "Food", "Lunch", BigDecimal.TEN, LocalDate.now(), "Food");
		TransactionDTO transactionDTO = new TransactionDTO(1L, "Food", "Lunch", BigDecimal.TEN, LocalDate.now(), "Food");
		
		when(transactionRepo.findById(id)).thenReturn(Optional.of(transaction));
		when(transactionMapper.toTransactionDTO(transaction)).thenReturn(transactionDTO);
		
		TransactionDTO result = transactionService.getTransactionById(id);
		
		assertEquals(transactionDTO.getId(), result.getId());
		assertEquals(transactionDTO.getAmount(), result.getAmount());
		
		
	}
	
	
}
