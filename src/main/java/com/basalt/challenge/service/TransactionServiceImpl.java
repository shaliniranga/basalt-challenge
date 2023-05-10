/**
 * 
 */
package com.basalt.challenge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.basalt.challenge.entity.TransactionEntity;
import com.basalt.challenge.repository.TransactionRepo;

/**
 * @author ShaliniRanga
 *
 */
@Service
public class TransactionServiceImpl {
	
	@Autowired
    private TransactionRepo repository;
		
	public TransactionEntity createOrUpdate(TransactionEntity entity) 
	{
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			Optional<TransactionEntity> service = repository.findById(entity.getId());
			
			if(service.isPresent()) 
			{
				TransactionEntity newEntity = service.get();
				newEntity.setDescription(entity.getDescription());
				newEntity.setTrans_type(entity.getTrans_type());
				newEntity.setAmount(entity.getAmount());
				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
	}


	public void deleteById(Long id) throws Exception
	{
		Optional<TransactionEntity> service = repository.findById(id);
		
		if(service.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new Exception("No transaction record exist for given id");
		}
	}


	public List<TransactionEntity> getAll()
	{
		List<TransactionEntity> result = (List<TransactionEntity>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<TransactionEntity>();
		}
	}
	
	public TransactionEntity getId(Long id) throws Exception 
	{
		Optional<TransactionEntity> service = repository.findById(id);
		
		if(service.isPresent()) {
			return service.get();
		} else {
			throw new Exception("No transaction record exist for given id");
		}
	}
	
	
	public int getType() {
		
		Integer debit = repository.findByType("debit");
		Integer credit = repository.findByType("credit");
		Integer balance = credit - debit;
		return balance;
		
	}
	
	public int getDebitType() {
		Integer debit = repository.findByType("debit");
		if(debit == null)
		{
			return debit =0;
		}
		System.out.println("debit " +debit);
		return debit;
		
	}
	
	public int getCreditType() {
		Integer credit = repository.findByType("credit");
		if(credit == null)
		{
			return credit =0;
		}
		return credit;
		
		
	}

}
