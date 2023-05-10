/**
 * 
 */
package com.basalt.challenge.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.basalt.challenge.entity.TransactionEntity;

/**
 * @author ShaliniRanga
 *
 */
@Repository
public interface TransactionRepo 
			extends CrudRepository<TransactionEntity, Long> {
	
	  @Query(value="select sum(amount) from transactions_catalog where trans_type = ?1 ",nativeQuery=true)
	  public Integer findByType(String debit);

}
